package ds.bookingService;

import java.io.IOException;

import ds.bookingService.BookingServiceGrpc.Service2ImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class BookingService extends Service2ImplBase{



	public static void main(String[] args) throws InterruptedException, IOException {
		BookingService service1 = new BookingService();

		int port = 50052;

		Server server = ServerBuilder.forPort(port)
				.addService(service1)
				.build()
				.start();

		System.out.println("Booking Service started, listening on " + port);

		server.awaitTermination();
	}


	@Override
	public void service2Do(RequestMessage request, StreamObserver<ResponseMessage> responseObserver) {

		//prepare the value to be set back
		int length = request.getText().length();
		
		//preparing the response message
		ResponseMessage reply = ResponseMessage.newBuilder().setLength(length).build();

		responseObserver.onNext( reply ); 

		responseObserver.onCompleted();

	}
}
