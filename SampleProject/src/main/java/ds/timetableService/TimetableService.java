package ds.timetableService;

import java.io.IOException;

import ds.timetableService.TimetableGrpc.Service1ImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class TimetableService extends Service1ImplBase{



	public static void main(String[] args) throws InterruptedException, IOException {
		TimetableService TimetableService = new TimetableService();

		int port = 50051;

		Server server = ServerBuilder.forPort(port)
				.addService(TimetableService)
				.build()
				.start();

		System.out.println("Timetable Service started, listening on " + port);

		server.awaitTermination();
	}


	@Override
	public void service1Do(RequestMessage request, StreamObserver<ResponseMessage> responseObserver) {
		System.out.println("Requesting the timetable");

		//prepare the value to be set back
		//int length = request.getText().length();
		String trainNo = request.getText();
		//if (trainNo == "1") {
			
		//}
		//preparing the response message
		ResponseMessage reply = ResponseMessage.newBuilder().build();

		responseObserver.onNext(reply); 

		responseObserver.onCompleted();

	}
}
