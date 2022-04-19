package ds.examples.maths;


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
import javax.swing.JButton;
import javax.swing.JComboBox;
//import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//import ds.examples.maths.CalculateRequest.Operation;
import ds.examples.maths.MathServiceGrpc.MathServiceBlockingStub;
import ds.examples.maths.MathServiceGrpc.MathServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class MainGUIApplication {

	private static MathServiceBlockingStub blockingStub;
	private static MathServiceStub asyncStub;

	private ServiceInfo mathServiceInfo;
	
	
	private JFrame frame;
	private JTextField departInput;
	private JTextField arrivalInput;
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
		//System.out.println(mathServiceInfo.getHostAddresses());
		//String host = mathServiceInfo.getHostAddresses()[0];
		//int port = mathServiceInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = MathServiceGrpc.newBlockingStub(channel);

		asyncStub = MathServiceGrpc.newStub(channel);

		
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
					System.out.println("\t type:"+ event.getType());
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
		frame.setBounds(300, 300, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		JPanel panel_service_title = new JPanel();
		frame.getContentPane().add(panel_service_title);
		panel_service_title.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 5));
		
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
		JComboBox comboOperation = new JComboBox();
		comboOperation.setModel(new DefaultComboBoxModel(new String[] {"ADDITION", "SUBTRACTION", "MULTIPLICATION", "DIVISION"}));
		panel_service_1.add(comboOperation);
	*/
		
		JButton btnJourneyFinder = new JButton("Find journeys");
		btnJourneyFinder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String station1 = departInput.getText();
				String station2 = arrivalInput.getText();

				//int index = comboOperation.getSelectedIndex();
				//Operation operation = Operation.forNumber(index);
				
				Stations req = Stations.newBuilder().setDepartStation(station1).setArrivalStation(station2).build();

				TrainDetails response = blockingStub.viewTimetable(req);

					//textResponse.append("reply:"+ response.getResult() + " mes:"+ response.getMessage() + "\n");
				if (station1.equals(null) || station2.equals(null)) {
					textResponse.append("This is not a valid train station. Try again.");
					System.out.println("This is not a valid train station. Try again.");
				}
				else {
					textResponse.append(station1 + " to " + station2 + ": Price is: €"+ response.getPrice() + ", Time is: "+ response.getTime() + "PM, Train number is: " + response.getTrainNo() + "\n");
				
					System.out.println((station1 + " to " + station2 + ": Price is: €"+ response.getPrice() + ", Time is: "+ response.getTime() + "PM, Train number is: " + response.getTrainNo() + "\n"));
					//System.out.println("res: " + response.getResult() + " mes: " + response.getMessage());
				}

			}
		});
		panel_service_1.add(btnJourneyFinder);
		
		textResponse = new JTextArea(10, 60);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		panel_service_1.add(scrollPane);
		
		
		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		
		JPanel panel_service_3 = new JPanel();
		frame.getContentPane().add(panel_service_3);
		
		
		
	}

}
