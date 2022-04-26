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






public class BookingServer extends BookingServiceImplBase{
	
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
	
	public StreamObserver<Booking> makeBookings(StreamObserver<Booking> responseObserver) {
		System.out.println("On server; inside the client streaming method");
		//int trainNo = request.getTrainNo();
		//String specialReq = request.getSpecialRequestMsg();
		System.out.println("On server; inside the streaming method");
		return new StreamObserver<Booking>() {

			@Override
			public void onNext(Booking value) {
				System.out.println("On server; message received from the client." + value.getTrainNo() + value.getSpecialRequestMsg());
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
			Booking.Builder responseBuilder = Booking.newBuilder();
			
			responseBuilder.setSpecialRequestMsg("Received");
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
				
			}};
		//Response Build
		//newResponse.Builder responseBuilder = newResponse.newBuilder();
	}
	
	public void login(LoginRequest request, StreamObserver<LoginReply> responseObserver) {
		System.out.println("receiving the request method for login " +request.getUsername() + request.getPassword());
		LoginReply.Builder responseBuilder = LoginReply.newBuilder();
		
		if (request.getUsername().equals("Shane98")) {
			if(request.getPassword().equals("cherries!")) {
				System.out.println("Login successful!");
				responseBuilder.setMessage("Login Successful!");
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted();
				
			}
		}
		else {
			System.out.println("Login unsuccessful. Try again.");
			responseBuilder.setMessage("Login Unsuccessful. Try Again.");
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
		}
		
	}

}
