package ca.railway.timetableService1;

import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

//import ca.railway.bookingService2.LoginReply;
//import ca.railway.bookingService2.LoginRequest;
import ca.railway.timetableService1.RailwayServiceGrpc.RailwayServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class RailwayServer extends RailwayServiceImplBase {

	public static void main(String[] args) {
		RailwayServer railwayserver = new RailwayServer();

		Properties prop = railwayserver.getProperties();

		railwayserver.registerService(prop);

		int port = Integer.valueOf(prop.getProperty("service_port"));// #.50051;

		try {

			Server server = ServerBuilder.forPort(port).addService(railwayserver).build().start();

			System.out.println("Railway Server started, listening on port " + port);

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

		try (InputStream input = new FileInputStream("src/main/resources/service1Timetable.properties")) {

			prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println("Service 1 - Timetable properies ...");
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

	public void viewPricing(RequestPrices request, StreamObserver<Pricing> responseObserver) {
		System.out.println("receiving Request method " + request.getRequest());
		
		Pricing reply = Pricing.newBuilder().setPrice("\n1 Stop: €7.25 \n2 Stops: €8.25 \n3 Stops: €8.87 \n4 Stops: €9.03 \n5 Stops: €10.10\n").build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}

	public void viewTimetable(Stations request, StreamObserver<TrainDetails> responseObserver) {

		System.out.println(
				"receiving arrival station method " + request.getArrivalStation() + " , " + request.getDepartStation());

		String time = "";
		float price = Float.NaN;
		int trainNo = 0;
		String msg = "No additional information";

		String[] stationArray = { "Wexford", "Arklow", "Wicklow", "Greystones", "Bray", "Dun Laoghaire" };
		TrainDetails.Builder responseBuilder = TrainDetails.newBuilder();
		
		// DEPARTING FROM WEXFORD:
		if (request.getDepartStation().equals(stationArray[0])
				|| request.getDepartStation().equals(stationArray[0].toLowerCase())
				|| request.getDepartStation().equals(stationArray[0].toUpperCase())) {

			// TO WEXFORD:

			if (request.getArrivalStation().equals(stationArray[0])
					|| request.getArrivalStation().equals(stationArray[0].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[0].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "Cannot travel from Wexford to Wexford";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
				
				
			}

			// TO ARKLOW:

			else if (request.getArrivalStation().equals(stationArray[1])
					|| request.getArrivalStation().equals(stationArray[1].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[1].toUpperCase())) {
				time = "1:25";
				price = 7.25f;
				trainNo = 102;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO WICKLOW:

			else if (request.getArrivalStation().equals(stationArray[2])
					|| request.getArrivalStation().equals(stationArray[2].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[2].toUpperCase())) {
				time = "1:45";
				price = 8.25f;
				trainNo = 103;
				//Streaming multiple methods consecutively
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO GREYSTONES:

			else if (request.getArrivalStation().equals(stationArray[3])
					|| request.getArrivalStation().equals(stationArray[3].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[3].toUpperCase())) {
				time = "2:00";
				price = 8.87f;
				trainNo = 104;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO BRAY:

			else if (request.getArrivalStation().equals(stationArray[4])
					|| request.getArrivalStation().equals(stationArray[4].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[4].toUpperCase())) {
				time = "2:25";
				price = 9.03f;
				trainNo = 105;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO DUN LAOGHAIRE

			else if (request.getArrivalStation().equals(stationArray[5])
					|| request.getArrivalStation().equals(stationArray[5].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[5].toUpperCase())) {
				time = "2:50";
				price = 10.10f;
				trainNo = 106;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

		} // end of Wexford departures

		// DEPARTING FROM ARKLOW:

		else if (request.getDepartStation().equals(stationArray[1])
				|| request.getDepartStation().equals(stationArray[1].toLowerCase())
				|| request.getDepartStation().equals(stationArray[1].toUpperCase())) {

			// TO WEXFORD:

			if (request.getArrivalStation().equals(stationArray[0])
					|| request.getArrivalStation().equals(stationArray[0].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[0].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Wexford from Arklow.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO ARKLOW:

			else if (request.getArrivalStation().equals(stationArray[1])
					|| request.getArrivalStation().equals(stationArray[1].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[1].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "Cannot travel from Arklow to Arklow.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO WICKLOW:

			else if (request.getArrivalStation().equals(stationArray[2])
					|| request.getArrivalStation().equals(stationArray[2].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[2].toUpperCase())) {
				time = "1:45";
				price = 7.25f;
				trainNo = 107;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO GREYSTONES:

			else if (request.getArrivalStation().equals(stationArray[3])
					|| request.getArrivalStation().equals(stationArray[3].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[3].toUpperCase())) {
				time = "2:00";
				price = 8.25f;
				trainNo = 108;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO BRAY:

			else if (request.getArrivalStation().equals(stationArray[4])
					|| request.getArrivalStation().equals(stationArray[4].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[4].toUpperCase())) {
				time = "2:25";
				price = 8.87f;
				trainNo = 109;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO DUN LAOGHAIRE

			else if (request.getArrivalStation().equals(stationArray[5])
					|| request.getArrivalStation().equals(stationArray[5].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[5].toUpperCase())) {
				time = "2:50";
				price = 9.03f;
				trainNo = 110;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}
		} // end of Arklow departures

		// DEPARTING FROM WICKLOW:

		else if (request.getDepartStation().equals(stationArray[2])
				|| request.getDepartStation().equals(stationArray[2].toLowerCase())
				|| request.getDepartStation().equals(stationArray[2].toUpperCase())) {

			// TO WEXFORD:

			if (request.getArrivalStation().equals(stationArray[0])
					|| request.getArrivalStation().equals(stationArray[0].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[0].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Wexford from Wicklow.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO ARKLOW:

			else if (request.getArrivalStation().equals(stationArray[1])
					|| request.getArrivalStation().equals(stationArray[1].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[1].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Arklow from Wicklow.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO WICKLOW:

			else if (request.getArrivalStation().equals(stationArray[2])
					|| request.getArrivalStation().equals(stationArray[2].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[2].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "Cannot travel from Wicklow to Wicklow.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO GREYSTONES:

			else if (request.getArrivalStation().equals(stationArray[3])
					|| request.getArrivalStation().equals(stationArray[3].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[3].toUpperCase())) {
				time = "2:00";
				price = 7.25f;
				trainNo = 111;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO BRAY:

			else if (request.getArrivalStation().equals(stationArray[4])
					|| request.getArrivalStation().equals(stationArray[4].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[4].toUpperCase())) {
				time = "2:25";
				price = 8.25f;
				trainNo = 112;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO DUN LAOGHAIRE:

			else if (request.getArrivalStation().equals(stationArray[5])
					|| request.getArrivalStation().equals(stationArray[5].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[5].toUpperCase())) {
				time = "2:50";
				price = 8.87f;
				trainNo = 113;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}
		} // End of Wicklow Departures

		// DEPARTING FROM GREYSTONES:

		else if (request.getDepartStation().equals(stationArray[3])
				|| request.getDepartStation().equals(stationArray[3].toLowerCase())
				|| request.getDepartStation().equals(stationArray[3].toUpperCase())) {

			// TO WEXFORD:

			if (request.getArrivalStation().equals(stationArray[0])
					|| request.getArrivalStation().equals(stationArray[0].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[0].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Wexford from Greystones.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO ARKLOW:

			else if (request.getArrivalStation().equals(stationArray[1])
					|| request.getArrivalStation().equals(stationArray[1].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[1].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Arklow from Greystones.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO WICKLOW:

			else if (request.getArrivalStation().equals(stationArray[2])
					|| request.getArrivalStation().equals(stationArray[2].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[2].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Wicklow from Greystones.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO GREYSTONES:

			else if (request.getArrivalStation().equals(stationArray[3])
					|| request.getArrivalStation().equals(stationArray[3].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[3].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "Cannot travel from Greystones to Greystones.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO BRAY:

			else if (request.getArrivalStation().equals(stationArray[4])
					|| request.getArrivalStation().equals(stationArray[4].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[4].toUpperCase())) {
				time = "2:25";
				price = 7.25f;
				trainNo = 114;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO DUN LAOGHAIRE:

			else if (request.getArrivalStation().equals(stationArray[5])
					|| request.getArrivalStation().equals(stationArray[5].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[5].toUpperCase())) {
				time = "2:50";
				price = 8.25f;
				trainNo = 115;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}
		}

		// DEPARTING FROM BRAY:

		else if (request.getDepartStation().equals(stationArray[4])
				|| request.getDepartStation().equals(stationArray[4].toLowerCase())
				|| request.getDepartStation().equals(stationArray[4].toUpperCase())) {

			// TO WEXFORD:

			if (request.getArrivalStation().equals(stationArray[0])
					|| request.getArrivalStation().equals(stationArray[0].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[0].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Wexford from Bray.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO ARKLOW:

			else if (request.getArrivalStation().equals(stationArray[1])
					|| request.getArrivalStation().equals(stationArray[1].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[1].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Arklow from Bray.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO WICKLOW:

			else if (request.getArrivalStation().equals(stationArray[2])
					|| request.getArrivalStation().equals(stationArray[2].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[2].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Wicklow from Bray.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO GREYSTONES:

			else if (request.getArrivalStation().equals(stationArray[3])
					|| request.getArrivalStation().equals(stationArray[3].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[3].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Greystones from Bray.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO BRAY:

			else if (request.getArrivalStation().equals(stationArray[4])
					|| request.getArrivalStation().equals(stationArray[4].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[4].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "Cannot travel from Bray to Bray.";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}

			// TO DUN LAOGHAIRE:

			else if (request.getArrivalStation().equals(stationArray[5])
					|| request.getArrivalStation().equals(stationArray[5].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[5].toUpperCase())) {
				time = "2:50";
				price = 7.25f;
				trainNo = 116;
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}
		}

		// DEPARTING FROM DUN LAOGHAIRE (End of Line):

		else if (request.getDepartStation().equals(stationArray[5])
				|| request.getDepartStation().equals(stationArray[5].toLowerCase())
				|| request.getDepartStation().equals(stationArray[5].toUpperCase())) {

			time = "";
			price = 0f;
			trainNo = 0;
			msg = "Dun Laoghaire is the final station in the northbound line. No journeys available.";
			//Streaming multiple methods consecutively
			responseBuilder.setTime(time);
			responseObserver.onNext(responseBuilder.build());
			responseBuilder.setPrice(price);
			responseObserver.onNext(responseBuilder.build());
			responseBuilder.setTrainNo(trainNo);
			responseObserver.onNext(responseBuilder.build());
			responseBuilder.setMsg(msg);
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted(); // Finished Streaming
		}

		else {
			System.out.println("Did not match.");
			time = "";
			price = 0f;
			trainNo = 0;
			msg = "No journeys available.";
			//Streaming multiple methods consecutively
			responseBuilder.setTime(time);
			responseObserver.onNext(responseBuilder.build());
			responseBuilder.setPrice(price);
			responseObserver.onNext(responseBuilder.build());
			responseBuilder.setTrainNo(trainNo);
			responseObserver.onNext(responseBuilder.build());
			responseBuilder.setMsg(msg);
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted(); // Finished Streaming
		}

	}

	
	public void amenities(TrainNo request, StreamObserver<TrainAmenities> responseObserver) {
		System.out.println("Receiving Request Method: " + request.getTrainNo());
		TrainAmenities.Builder reply = TrainAmenities.newBuilder();
		
		
		//Catering options will change dynamically as the trains progress northbound.
		if(request.getTrainNo() <= 110) {
			
			reply.setCatering("Catering: Sandwiches and wine.");
			reply.setBikeSlot("3 Bike slots. Pets allowed: ");
			reply.setPetsAllowed(false);
			responseObserver.onNext(reply.build());
			responseObserver.onCompleted();
		}
		else if(request.getTrainNo() == 111) {
			reply.setCatering("Catering: SPECIAL - Tea and cakes.");
			reply.setBikeSlot("No Bike slots. Pets allowed: ");
			reply.setPetsAllowed(false);
			responseObserver.onNext(reply.build());
			responseObserver.onCompleted();
		}
		else if(request.getTrainNo() > 111) {
			reply.setCatering("Catering: Limited availability - Select snacks and beer.");
			reply.setBikeSlot("6 Bike slots. Pets allowed: ");
			reply.setPetsAllowed(false);
			responseObserver.onNext(reply.build());
			responseObserver.onCompleted();
		}
		else {
			reply.setCatering("No amenities");
			reply.setBikeSlot("No amenities");
			reply.setPetsAllowed(false);
		}
		
	}
	/*
	public void viewTimetable(Stations request, StreamObserver<TrainDetails> responseObserver) {
		System.out.println(
				"receiving arrival station method " + request.getArrivalStation() + " , " + request.getDepartStation());
		String time = "";
		float price = Float.NaN;
		int trainNo = 0;
		String msg = "No additional information";
		String[] stationArray = { "Wexford", "Arklow", "Wicklow", "Greystones", "Bray", "Dun Laoghaire" };
		TrainDetails.Builder responseBuilder = TrainDetails.newBuilder();
		// DEPARTING FROM WEXFORD:
		if (request.getDepartStation().equals(stationArray[0])
				|| request.getDepartStation().equals(stationArray[0].toLowerCase())
				|| request.getDepartStation().equals(stationArray[0].toUpperCase())) {
			// TO WEXFORD:
			if (request.getArrivalStation().equals(stationArray[0])
					|| request.getArrivalStation().equals(stationArray[0].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[0].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "Cannot travel from Wexford to Wexford";
				//Streaming multiple methods consecutively
				responseBuilder.setTime(time);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setPrice(price);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setTrainNo(trainNo);
				responseObserver.onNext(responseBuilder.build());
				responseBuilder.setMsg(msg);
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted(); // Finished Streaming
			}
*/
	
	
	
	/*
	 * //service implmentation for public void generateRandomNumbers(RandomRequest
	 * request, StreamObserver<NumberResponse> responseObserver) {
	 * 
	 * 
	 * System.out.
	 * printf("receiving generateRandom method num: %d from: %d to: %d \n",
	 * request.getNumbers(), request.getMin(), request.getMax() );
	 * 
	 * Random rand = new Random();
	 * 
	 * for(int i=0; i<request.getNumbers(); i++) {
	 * 
	 * int random_value = rand.nextInt(request.getMax() - request.getMin()) +
	 * request.getMin() + 1;
	 * 
	 * NumberResponse reply =
	 * NumberResponse.newBuilder().setNumber(random_value).build();
	 * 
	 * responseObserver.onNext(reply);
	 * 
	 * try { //wait for a second Thread.sleep(1000); } catch (InterruptedException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * 
	 * responseObserver.onCompleted();
	 * 
	 * 
	 * }
	 */

	/*
	 * public StreamObserver<ConvertMessage>
	 * convertBase(StreamObserver<ConvertResponse> responseObserver) {
	 * 
	 * return new StreamObserver<ConvertMessage> () {
	 * 
	 * @Override public void onNext(ConvertMessage msg) {
	 * System.out.println("receiving convertBase method num: "+ msg.getNumber() +
	 * " from-base: "+ msg.getFromBase() + " to-base: "+ msg.getToBase() );
	 * 
	 * String converted = Integer.toString(Integer.parseInt(msg.getNumber(),
	 * msg.getFromBase()), msg.getToBase());
	 * 
	 * ConvertResponse reply =
	 * ConvertResponse.newBuilder().setNumber(converted).setBase(msg.getToBase()).
	 * build();
	 * 
	 * responseObserver.onNext(reply);
	 * 
	 * }
	 * 
	 * @Override public void onError(Throwable t) {
	 * 
	 * t.printStackTrace();
	 * 
	 * }
	 * 
	 * @Override public void onCompleted() {
	 * System.out.println("receiving convertBase completed ");
	 * 
	 * //completed too responseObserver.onCompleted(); }
	 * 
	 * }; }
	 */
}
