package ca.railway.bookingService2;

import ca.railway.timetableService1.*;
import ca.railway.bookingService2.BookingServiceGrpc.BookingServiceImplBase;
import io.grpc.stub.StreamObserver;

import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class BookingServer extends BookingServiceImplBase {
	boolean loginBool;

	public static void main(String[] args) {
		BookingServer bookingserver = new BookingServer();

		Properties prop = bookingserver.getProperties();

		bookingserver.registerService(prop);

		int port = Integer.valueOf(prop.getProperty("service_port"));// #.50051;

		try {

			Server server = ServerBuilder.forPort(port).addService(bookingserver).build().start();

			System.out.println("Booking Server started, listening on port " + port);

			server.awaitTermination();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Properties getProperties() {

		Properties prop = null;

		try (InputStream input = new FileInputStream("src/main/resources/service2Booking.properties")) {

			prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println("Service 2 - Booking properies ...");
			System.out.println("\t service_type: " + prop.getProperty("service_type"));
			System.out.println("\t service_name: " + prop.getProperty("service_name"));
			System.out.println("\t service_description: " + prop.getProperty("service_description"));
			System.out.println("\t service_port: " + prop.getProperty("service_port"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return prop;
	}

	private void registerService(Properties prop) {

		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			String service_type = prop.getProperty("service_type");// "_http._tcp.local.";
			String service_name = prop.getProperty("service_name");// "example";
			// int service_port = 1234;
			int service_port = Integer.valueOf(prop.getProperty("service_port"));// #.50051;

			String service_description_properties = prop.getProperty("service_description");// "path=index.html";

			// Register a service
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port,
					service_description_properties);
			jmdns.registerService(serviceInfo);

			System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);

			// Wait a bit
			Thread.sleep(1000);

			// Unregister all services
			// jmdns.unregisterAllServices();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Client side streaming method
	public StreamObserver<BookingRequest> booking(BookingRequest request,
			StreamObserver<BookingConfirmationMsg> responseObserver) {
		System.out.println(
				"receiving the request method for booking " + request.getTrainNo() + request.getSpecialRequest());

		return new StreamObserver<BookingRequest>() {

			@Override
			public void onNext(BookingRequest value) {
				System.out.println("On server; message received. \nTrain Number: " + value.getTrainNo()
						+ ", \nSpecial Request: " + value.getSpecialRequest());

			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				BookingConfirmationMsg.Builder responseBuilder = BookingConfirmationMsg.newBuilder();
				if (request.getTrainNo() > 0) { // When a train number is passed.
					if (request.getSpecialRequest().equals("Wheelchair")
							|| request.getSpecialRequest().equals("wheelchair")) {
						int i = (int) Math.random() * 5;
						responseBuilder.setBookingNo(i);
						responseObserver.onNext(responseBuilder.build());

						responseBuilder.setTrainNo(request.getTrainNo());
						responseObserver.onNext(responseBuilder.build());

						responseBuilder
								.setSpecialRequestReply("The train staff will help you with wheelchair accessibility.");
						responseObserver.onNext(responseBuilder.build());

						responseObserver.onCompleted();
					} else if (request.getSpecialRequest().equals("Allergy")
							|| request.getSpecialRequest().equals("allergy")) {
						int i = (int) Math.random() * 5;
						responseBuilder.setBookingNo(i);
						responseObserver.onNext(responseBuilder.build());

						responseBuilder.setTrainNo(request.getTrainNo());
						responseObserver.onNext(responseBuilder.build());

						responseBuilder
								.setSpecialRequestReply("The train staff will be aware of your notified allergies.");
						responseObserver.onNext(responseBuilder.build());

						responseObserver.onCompleted();
					} else {
						responseBuilder.setBookingNo(0);
						responseObserver.onNext(responseBuilder.build());
						responseBuilder.setTrainNo(0);
						responseObserver.onNext(responseBuilder.build());
						responseBuilder.setSpecialRequestReply("N/A");
						responseObserver.onNext(responseBuilder.build());
						responseObserver.onCompleted();
						System.out.println("");
					}

				} else {
					responseBuilder.setBookingNo(0);
					responseObserver.onNext(responseBuilder.build());
					responseBuilder.setTrainNo(0);
					responseObserver.onNext(responseBuilder.build());
					responseBuilder.setSpecialRequestReply("N/A");
					responseObserver.onNext(responseBuilder.build());
					responseObserver.onCompleted();
					System.out.println("Enter valid train No");
				}

			}
		};

	}

	public void login(LoginRequest request, StreamObserver<LoginReply> responseObserver) {
		System.out.println("receiving the request method for login " + request.getUsername() + request.getPassword());
		LoginReply.Builder responseBuilder = LoginReply.newBuilder();

		if (request.getUsername().equals("Shane98")) {
			if (request.getPassword().equals("cherries!")) {
				System.out.println("Login successful!");
				responseBuilder.setMessage("Login Successful!\n");
				if (loginBool == true) {
					System.out.println("Already Logged In.");
					responseBuilder.setMessage("Login Successful!\n");
					responseObserver.onNext(responseBuilder.build());
					responseObserver.onCompleted();
				}
				loginBool = true;
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted();

			} else {
				System.out.println("Password is correct for this valid username.\n");
				responseBuilder.setMessage("Password is incorrect for this valid username.\n");
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted();
			}
		} else {
			System.out.println("Login unsuccessful. Try again.\n");
			responseBuilder.setMessage("Login Unsuccessful. Try Again.\n");
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
		}

	}

}
