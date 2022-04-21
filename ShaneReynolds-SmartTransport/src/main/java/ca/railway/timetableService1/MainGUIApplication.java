package ca.railway.timetableService1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ca.railway.timetableService1.RailwayServiceGrpc.RailwayServiceBlockingStub;
import ca.railway.timetableService1.RailwayServiceGrpc.RailwayServiceStub;

import javax.swing.JButton;
import javax.swing.JComboBox;
//import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class MainGUIApplication {

	private static RailwayServiceBlockingStub blockingStub;
	private static RailwayServiceStub asyncStub;

	private ServiceInfo mathServiceInfo;

	private JFrame frame;
	private JTextField departInput;
	private JTextField arrivalInput;
	private JTextField amenitiesInput;
	private JTextArea textResponse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUIApplication window = new MainGUIApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUIApplication() {

		String math_service_type = "_maths._tcp.local.";
		discoverMathService(math_service_type);
		// System.out.println(mathServiceInfo.getHostAddresses());
		// String host = mathServiceInfo.getHostAddresses()[0];
		// int port = mathServiceInfo.getPort();

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		// stubs -- generate from proto
		blockingStub = RailwayServiceGrpc.newBlockingStub(channel);

		asyncStub = RailwayServiceGrpc.newStub(channel);

		initialize();
	}

	private void discoverMathService(String service_type) {

		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			jmdns.addServiceListener(service_type, new ServiceListener() {

				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Math Service resolved: " + event.getInfo());

					mathServiceInfo = event.getInfo();

					int port = mathServiceInfo.getPort();

					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:" + event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + mathServiceInfo.getNiceTextString());
					System.out.println("\t host: " + mathServiceInfo.getHostAddresses()[0]);

				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Smart Railway removed: " + event.getInfo());

				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Smart Railway Service added: " + event.getInfo());

				}
			});

			// Wait a bit
			Thread.sleep(2000);

			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Client - Service Controller");
		frame.setBounds(500, 500, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

		frame.getContentPane().setLayout(bl);

		JPanel panel_service_title = new JPanel();
		frame.getContentPane().add(panel_service_title);
		panel_service_title.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 5));

		JLabel titleLabel = new JLabel("Northbound Rail Line");
		panel_service_title.add(titleLabel);

		JPanel panel_service_info = new JPanel();
		JPanel panel_service_info2 = new JPanel();
		JLabel info = new JLabel("Stations: Wexford, Arklow, Wicklow, Greystones, Bray, Dun Laoghaire");
		info.setForeground(Color.gray);
		frame.getContentPane().add(panel_service_info);
		panel_service_info.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 5));
		frame.getContentPane().add(panel_service_info2);
		panel_service_info2.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 5));
		panel_service_info.add(info);

		JButton btnPricer = new JButton("See all prices");
		btnPricer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RequestPrices req = RequestPrices.newBuilder().setRequest("").build();
				Pricing response = blockingStub.viewPricing(req);
				textResponse.append(response.getPrice());
				System.out.println(response.getPrice());
			}
		});

		panel_service_info.add(btnPricer);

		JLabel amenitiesLabel = new JLabel("Train Number");
		panel_service_info2.add(amenitiesLabel);

		amenitiesInput = new JTextField();
		panel_service_info2.add(amenitiesInput);
		amenitiesInput.setColumns(5);

		JButton btnAmenities = new JButton("See Amenities");
		btnAmenities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Parsing from string to int
				String text = amenitiesInput.getText();
				int trainNo = Integer.parseInt(text);



				TrainNo req = TrainNo.newBuilder().setTrainNo(trainNo).build();
				// int trainNo = req.getTrainNo();
				TrainAmenities response = blockingStub.amenities(req);
				textResponse.append("For Train Number " + amenitiesInput.getText() + ": " + response.getCatering()
						+ response.getBikeSlot() + response.getPetsAllowed() + "\n");
				System.out.println("For Train Number " + amenitiesInput.getText() + ": " + response.getCatering()
						+ response.getBikeSlot() + response.getPetsAllowed() + "\n");
			}
		});

		panel_service_info2.add(btnAmenities);

		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 5));

		JLabel departLabel = new JLabel("Departure Station");
		panel_service_1.add(departLabel);

		departInput = new JTextField();
		panel_service_1.add(departInput);
		departInput.setColumns(10);

		JLabel arrivalLabel = new JLabel("Arrival Station");
		panel_service_1.add(arrivalLabel);

		arrivalInput = new JTextField();
		panel_service_1.add(arrivalInput);
		arrivalInput.setColumns(10);

		/*
		 * JComboBox comboOperation = new JComboBox(); comboOperation.setModel(new
		 * DefaultComboBoxModel(new String[] {"ADDITION", "SUBTRACTION",
		 * "MULTIPLICATION", "DIVISION"})); panel_service_1.add(comboOperation);
		 */

		JButton btnJourneyFinder = new JButton("Find journeys");

		btnJourneyFinder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String station1 = departInput.getText();
				String station2 = arrivalInput.getText();

				// int index = comboOperation.getSelectedIndex();
				// Operation operation = Operation.forNumber(index);

				Stations req = Stations.newBuilder().setDepartStation(station1).setArrivalStation(station2).build();

				// TrainDetails response = blockingStub.viewTimetable(req);
				Iterator<TrainDetails> response = blockingStub.viewTimetable(req);

				// textResponse.append("reply:"+ response.getResult() + " mes:"+
				// response.getMessage() + "\n");

				int counter = 0;
				while (response.hasNext()) {

					TrainDetails individualResponse = response.next();

					if (station1.equals(null) || station2.equals(null)) {
						textResponse.append("This is not a valid train station. Try again.");
						System.out.println("This is not a valid train station. Try again.");
					} else {
						if (counter == 0) {
							textResponse.append("\n\n" + station1 + " to " + station2 + ":");
						} else if (counter == 1) {
							textResponse.append("\nPrice is: €" + individualResponse.getPrice());
						} else if (counter == 2) {
							textResponse.append("\nArrival Time is: " + individualResponse.getTime());
						} else if (counter == 3) {
							textResponse.append("PM\nTrain number is: " + individualResponse.getTrainNo());
							textResponse.append("\nAdditional Info: " + individualResponse.getMsg() + "\n");

						} else {
							continue;

						}
						counter++;
					}

					// System.out.println(station1 + " to " + station2 + ":");

					// System.out.println("Price is: €" + individualResponse.getPrice());

					// System.out.println("Arrival Time is: " + individualResponse.getTime() +
					// "PM");

					// System.out.println("Train number is: " + individualResponse.getTrainNo());

					// System.out.println("Additional Info: " + individualResponse.getMsg() + "\n");

				}

			}
		});
		panel_service_1.add(btnJourneyFinder);

		textResponse = new JTextArea(10, 80);
		textResponse.setLineWrap(true);
		textResponse.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(textResponse);

		// textResponse.setSize(new Dimension(15, 30));
		panel_service_1.add(scrollPane);

		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);

		JPanel panel_service_3 = new JPanel();
		frame.getContentPane().add(panel_service_3);

	}

}
