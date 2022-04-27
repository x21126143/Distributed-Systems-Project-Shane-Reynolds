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
import ca.railway.bookingService2.Booking;
import ca.railway.bookingService2.BookingServiceGrpc;
import ca.railway.bookingService2.BookingServiceGrpc.BookingServiceBlockingStub;
import ca.railway.bookingService2.BookingServiceGrpc.BookingServiceStub;
import ca.railway.bookingService2.LoginReply;
import ca.railway.bookingService2.LoginRequest;
import ca.railway.supportService3.SupportServiceGrpc;
import ca.railway.supportService3.SupportServiceGrpc.SupportServiceBlockingStub;
import ca.railway.supportService3.complaintConfirmation;
import ca.railway.supportService3.complaintMsg;
import ca.railway.timetableService1.*;

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
import io.grpc.stub.StreamObserver;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Random;
import java.awt.event.ActionEvent;

public class MainGUIApplication {

	private static RailwayServiceBlockingStub blockingStub;
	private static RailwayServiceStub asyncStub;

	private static BookingServiceBlockingStub blockingStub2;
	private static BookingServiceStub asyncStub2;
	
	private static SupportServiceBlockingStub blockingStub3;

	private ServiceInfo railServiceInfo;

	private JFrame frame;
	private JTextField departInput;
	private JTextField arrivalInput;
	private JTextField trainInput;
	private JTextField specialInput;
	private JTextField amenitiesInput;
	private JTextField usernameInput;
	private JTextField passwordInput;
	private JTextField complaintInput;
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

		String rail_service_type = "_rail._tcp.local.";
		String booking_service_type = "_booking._tcp.local.";
		discoverRailService(rail_service_type);
		discoverRailService(booking_service_type);
		// System.out.println(mathServiceInfo.getHostAddresses());
		// String host = mathServiceInfo.getHostAddresses()[0];
		// int port = mathServiceInfo.getPort();

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		ManagedChannel channel2 = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
		ManagedChannel channel3 = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
		// stubs -- generate from proto
		blockingStub = RailwayServiceGrpc.newBlockingStub(channel);
		blockingStub2 = BookingServiceGrpc.newBlockingStub(channel2);
		blockingStub3 = SupportServiceGrpc.newBlockingStub(channel3);
		
		asyncStub2 = BookingServiceGrpc.newStub(channel2);

		initialize();
	}

	private void discoverRailService(String service_type) {

		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			JmDNS jmdns2 = JmDNS.create(InetAddress.getLocalHost());

			jmdns.addServiceListener(service_type, new ServiceListener() {

				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Rail Service resolved: " + event.getInfo());

					railServiceInfo = event.getInfo();

					int port = railServiceInfo.getPort();

					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:" + event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + railServiceInfo.getNiceTextString());
					System.out.println("\t host: " + railServiceInfo.getHostAddresses()[0]);

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
		frame.setForeground(Color.cyan);
		frame.setTitle("Client - Service Controller");
		frame.setBounds(500, 500, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

		frame.getContentPane().setLayout(bl);

		JPanel panel_service_login = new JPanel();

		frame.setForeground(Color.cyan);
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
		frame.getContentPane().add(panel_service_login);
		panel_service_info.setForeground(Color.cyan);
		panel_service_login.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 5));
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

		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.RED);
		JLabel usernamesLabel = new JLabel("Enter username: ");

		JLabel passwordsLabel = new JLabel("Enter password: ");

		usernameInput = new JTextField();
		passwordInput = new JTextField();
		trainInput = new JTextField();
		specialInput = new JTextField();

		usernameInput.setColumns(10);
		passwordInput.setColumns(10);

		panel_service_login.add(usernamesLabel);
		panel_service_login.add(usernameInput);
		panel_service_login.add(passwordsLabel);
		panel_service_login.add(passwordInput);
		
		
		

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = usernameInput.getText();
				String pass = passwordInput.getText();

				LoginRequest req = LoginRequest.newBuilder().setUsername(user).setPassword(pass).build();
				LoginReply response = blockingStub2.login(req);

				textResponse.append(response.getMessage());
				System.out.println(response.getMessage());
				if(user.equals("Shane98") && pass.equals("cherries!")) {
						btnLogin.setForeground(Color.GREEN);
						System.out.println("Logged in..............");
				}
				else {
					btnLogin.setForeground(Color.RED);
				}
			}
		});

		panel_service_login.add(btnLogin);
		panel_service_info.add(btnPricer);
		
		JPanel panel_service_amenities = new JPanel();
		

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
		
		
		JButton btnComplaint = new JButton("Send Complaint");
		btnComplaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String complaint = complaintInput.getText();
				complaintMsg req = complaintMsg.newBuilder().setComplaint(complaint).build();
				
				complaintConfirmation response = blockingStub3.complaint(req);
				textResponse.append(response.getReply() + "\nYour Complaint Message:\n");
				textResponse.append(req.getComplaint());
				System.out.println(req.getComplaint());
			}
		});
		

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
		
		
		frame.getContentPane().add(panel_service_amenities);
		panel_service_amenities.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 5));

		JLabel amenitiesLabel = new JLabel("Train Number");
		panel_service_amenities.add(amenitiesLabel);

		amenitiesInput = new JTextField();
		panel_service_amenities.add(amenitiesInput);
		amenitiesInput.setColumns(5);
		
		
		panel_service_amenities.add(btnAmenities);
		
		
		
		
		JPanel panel_service_book = new JPanel();
		frame.getContentPane().add(panel_service_book);
		JLabel bookingLabel1 = new JLabel("Train Number");
		panel_service_book.add(bookingLabel1);
		panel_service_book.add(trainInput);
		
		JLabel bookingLabel2 = new JLabel("Special Request for this Booking");
		panel_service_book.add(bookingLabel2);
		panel_service_book.add(specialInput);
		trainInput.setColumns(10);
		specialInput.setColumns(10);

		JButton btnJourneyFinder = new JButton("Find journeys");

		btnJourneyFinder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String station1 = departInput.getText();
				String station2 = arrivalInput.getText();
				Stations req = Stations.newBuilder().setDepartStation(station1).setArrivalStation(station2).build();

				Iterator<TrainDetails> response = blockingStub.viewTimetable(req);


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


				}

			}
		});

		JButton btnJourneyBook = new JButton("Book");

		btnJourneyBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String trainNo = trainInput.getText();
				String special = specialInput.getText();
				// Client side streaming code:
				StreamObserver<Booking> responseObserver = new StreamObserver<Booking>() {

					public void onNext(Booking value) {
						System.out.println("Final response from the server " + value.getTrainNo());

					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub

					}
				};

				// returning a StreamObserver:

				StreamObserver<Booking> requestObserver = asyncStub2.makeBookings(responseObserver);
		        requestObserver.onNext(Booking.newBuilder().setTrainNo(trainNo).build());
				requestObserver.onNext(Booking.newBuilder().setSpecialRequestMsg(special).build());
			//	requestObserver.onNext(Booking.newBuilder().setTrainNo(3).build());

				Random random = new Random();
				
				System.out.println("Client successfully sent messages.");
				textResponse.append("\n");
				textResponse.append("Booking Confirmation Number: " + random.nextInt(100000) +"\n");
				textResponse.append("Train Number: " + trainNo + "\n");
				textResponse.append("Special Request from customer: " + special + "\n");

				requestObserver.onCompleted();

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textResponse.append("Train is booked.");

			}
			

		});
		
		complaintInput = new JTextField();
		JPanel panel_service_support1 = new JPanel();
		panel_service_support1.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 5));
		frame.getContentPane().add(panel_service_support1);
		
		JLabel supportLabel = new JLabel("Have a complaint? Please enter it here");
		panel_service_support1.add(supportLabel);
		
		panel_service_support1.add(complaintInput);
		complaintInput.setColumns(40);
		panel_service_support1.add(btnComplaint);

		panel_service_book.add(btnJourneyBook);
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
		
		
		
		panel_service_info.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 5));

	}

}
