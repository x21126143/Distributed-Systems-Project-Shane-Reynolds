package ds.timetableService;

import java.io.IOException;

import ds.timetableService.TimetableServiceGrpc.Service1ImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class TimetableService extends Service1ImplBase{



	public static void main(String[] args) throws InterruptedException, IOException {
		TimetableService service1 = new TimetableService();

		int port = 50051;

		Server server = ServerBuilder.forPort(port)
				.addService(service1)
				.build()
				.start();

		System.out.println("Service-1 started, listening on " + port);

		server.awaitTermination();
	}


	@Override
	public void service1Do(RequestMessage request, StreamObserver<ResponseMessage> responseObserver) {

		//prepare the value to be set back
		int length = request.getText().length();
		
		//preparing the response message
		ResponseMessage reply = ResponseMessage.newBuilder().setLength(length).build();

		responseObserver.onNext( reply ); 

		responseObserver.onCompleted();

	}
}
