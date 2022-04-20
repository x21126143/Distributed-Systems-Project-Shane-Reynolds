package ds.examples.maths;

import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

//import ds.examples.maths.CalculateRequest.Operation;
import ds.examples.maths.MathServiceGrpc.MathServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class MathServer extends MathServiceImplBase {

	public static void main(String[] args) {
		MathServer mathserver = new MathServer();

		Properties prop = mathserver.getProperties();

		mathserver.registerService(prop);

		int port = Integer.valueOf(prop.getProperty("service_port"));// #.50051;

		try {

			Server server = ServerBuilder.forPort(port).addService(mathserver).build().start();

			System.out.println("Math Server started, listening on " + port);

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

	public void viewTimetable(Stations request, StreamObserver<TrainDetails> responseObserver) {

		System.out.println(
				"receiving arrival station method " + request.getArrivalStation() + " , " + request.getDepartStation());

		String time = "";
		float price = Float.NaN;
		int trainNo = 0;
		String msg = "No additional information";

		String[] stationArray = { "Wexford", "Arklow", "Wicklow", "Greystones", "Bray", "Dun Laoghaire" };

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
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO ARKLOW:

			else if (request.getArrivalStation().equals(stationArray[1])
					|| request.getArrivalStation().equals(stationArray[1].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[1].toUpperCase())) {
				time = "1:25";
				price = 7.25f;
				trainNo = 102;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO WICKLOW:

			else if (request.getArrivalStation().equals(stationArray[2])
					|| request.getArrivalStation().equals(stationArray[2].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[2].toUpperCase())) {
				time = "1:45";
				price = 8.25f;
				trainNo = 103;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO GREYSTONES:

			else if (request.getArrivalStation().equals(stationArray[3])
					|| request.getArrivalStation().equals(stationArray[3].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[3].toUpperCase())) {
				time = "2:00";
				price = 8.87f;
				trainNo = 104;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO BRAY:

			else if (request.getArrivalStation().equals(stationArray[4])
					|| request.getArrivalStation().equals(stationArray[4].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[4].toUpperCase())) {
				time = "2:25";
				price = 9.03f;
				trainNo = 105;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO DUN LAOGHAIRE

			else if (request.getArrivalStation().equals(stationArray[5])
					|| request.getArrivalStation().equals(stationArray[5].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[5].toUpperCase())) {
				time = "2:50";
				price = 10.10f;
				trainNo = 106;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
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
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO ARKLOW:

			else if (request.getArrivalStation().equals(stationArray[1])
					|| request.getArrivalStation().equals(stationArray[1].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[1].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "Cannot travel from Arklow to Arklow.";
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO WICKLOW:

			else if (request.getArrivalStation().equals(stationArray[2])
					|| request.getArrivalStation().equals(stationArray[2].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[2].toUpperCase())) {
				time = "1:45";
				price = 7.25f;
				trainNo = 107;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO GREYSTONES:

			else if (request.getArrivalStation().equals(stationArray[3])
					|| request.getArrivalStation().equals(stationArray[3].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[3].toUpperCase())) {
				time = "2:00";
				price = 8.25f;
				trainNo = 108;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO BRAY:

			else if (request.getArrivalStation().equals(stationArray[4])
					|| request.getArrivalStation().equals(stationArray[4].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[4].toUpperCase())) {
				time = "2:25";
				price = 8.87f;
				trainNo = 109;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO DUN LAOGHAIRE

			else if (request.getArrivalStation().equals(stationArray[5])
					|| request.getArrivalStation().equals(stationArray[5].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[5].toUpperCase())) {
				time = "2:50";
				price = 9.03f;
				trainNo = 110;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
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
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO ARKLOW:

			else if (request.getArrivalStation().equals(stationArray[1])
					|| request.getArrivalStation().equals(stationArray[1].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[1].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Arklow from Wicklow.";
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO WICKLOW:

			else if (request.getArrivalStation().equals(stationArray[2])
					|| request.getArrivalStation().equals(stationArray[2].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[2].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "Cannot travel from Wicklow to Wicklow.";
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO GREYSTONES:

			else if (request.getArrivalStation().equals(stationArray[3])
					|| request.getArrivalStation().equals(stationArray[3].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[3].toUpperCase())) {
				time = "2:00";
				price = 7.25f;
				trainNo = 111;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO BRAY:

			else if (request.getArrivalStation().equals(stationArray[4])
					|| request.getArrivalStation().equals(stationArray[4].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[4].toUpperCase())) {
				time = "2:25";
				price = 8.25f;
				trainNo = 112;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO DUN LAOGHAIRE:

			else if (request.getArrivalStation().equals(stationArray[5])
					|| request.getArrivalStation().equals(stationArray[5].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[5].toUpperCase())) {
				time = "2:50";
				price = 8.87f;
				trainNo = 113;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
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
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO ARKLOW:

			else if (request.getArrivalStation().equals(stationArray[1])
					|| request.getArrivalStation().equals(stationArray[1].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[1].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Arklow from Greystones.";
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO WICKLOW:

			else if (request.getArrivalStation().equals(stationArray[2])
					|| request.getArrivalStation().equals(stationArray[2].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[2].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Wicklow from Greystones.";
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO GREYSTONES:

			else if (request.getArrivalStation().equals(stationArray[3])
					|| request.getArrivalStation().equals(stationArray[3].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[3].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "Cannot travel from Greystones to Greystones.";
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO BRAY:

			else if (request.getArrivalStation().equals(stationArray[4])
					|| request.getArrivalStation().equals(stationArray[4].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[4].toUpperCase())) {
				time = "2:25";
				price = 7.25f;
				trainNo = 114;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO DUN LAOGHAIRE:

			else if (request.getArrivalStation().equals(stationArray[5])
					|| request.getArrivalStation().equals(stationArray[5].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[5].toUpperCase())) {
				time = "2:50";
				price = 8.25f;
				trainNo = 115;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
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
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO ARKLOW:

			else if (request.getArrivalStation().equals(stationArray[1])
					|| request.getArrivalStation().equals(stationArray[1].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[1].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Arklow from Bray.";
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO WICKLOW:

			else if (request.getArrivalStation().equals(stationArray[2])
					|| request.getArrivalStation().equals(stationArray[2].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[2].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Wicklow from Bray.";
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO GREYSTONES:

			else if (request.getArrivalStation().equals(stationArray[3])
					|| request.getArrivalStation().equals(stationArray[3].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[3].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "This is a northbound line. Cannot travel back to Greystones from Bray.";
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO BRAY:

			else if (request.getArrivalStation().equals(stationArray[4])
					|| request.getArrivalStation().equals(stationArray[4].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[4].toUpperCase())) {
				time = "";
				price = 0f;
				trainNo = 0;
				msg = "Cannot travel from Bray to Bray.";
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

			// TO DUN LAOGHAIRE:

			else if (request.getArrivalStation().equals(stationArray[5])
					|| request.getArrivalStation().equals(stationArray[5].toLowerCase())
					|| request.getArrivalStation().equals(stationArray[5].toUpperCase())) {
				time = "2:50";
				price = 7.25f;
				trainNo = 116;
				TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo)
						.setMsg(msg).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
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
			TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo).setMsg(msg)
					.build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		}

		else {
			System.out.println("Did not match.");
			time = "";
			price = 0f;
			trainNo = 0;
			msg = "No journeys available.";
			TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo).setMsg(msg)
					.build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		}

		TrainDetails reply = TrainDetails.newBuilder().setTime(time).setPrice(price).setTrainNo(trainNo).setMsg(msg)
				.build();

		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}

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
