package proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: HelloService.proto")
public final class TuttoGrpc {

  private TuttoGrpc() {}

  public static final String SERVICE_NAME = "proto.Tutto";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<proto.IdLibro,
      proto.DettagliLibro> METHOD_UNLIBRO =
      io.grpc.MethodDescriptor.<proto.IdLibro, proto.DettagliLibro>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.Tutto", "unlibro"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              proto.IdLibro.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              proto.DettagliLibro.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<proto.Ciao,
      proto.NumeroLibri> METHOD_DAMMINUMERO =
      io.grpc.MethodDescriptor.<proto.Ciao, proto.NumeroLibri>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.Tutto", "damminumero"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              proto.Ciao.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              proto.NumeroLibri.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TuttoStub newStub(io.grpc.Channel channel) {
    return new TuttoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TuttoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TuttoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TuttoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TuttoFutureStub(channel);
  }

  /**
   */
  public static abstract class TuttoImplBase implements io.grpc.BindableService {

    /**
     */
    public void unlibro(proto.IdLibro request,
        io.grpc.stub.StreamObserver<proto.DettagliLibro> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UNLIBRO, responseObserver);
    }

    /**
     */
    public void damminumero(proto.Ciao request,
        io.grpc.stub.StreamObserver<proto.NumeroLibri> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DAMMINUMERO, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_UNLIBRO,
            asyncUnaryCall(
              new MethodHandlers<
                proto.IdLibro,
                proto.DettagliLibro>(
                  this, METHODID_UNLIBRO)))
          .addMethod(
            METHOD_DAMMINUMERO,
            asyncUnaryCall(
              new MethodHandlers<
                proto.Ciao,
                proto.NumeroLibri>(
                  this, METHODID_DAMMINUMERO)))
          .build();
    }
  }

  /**
   */
  public static final class TuttoStub extends io.grpc.stub.AbstractStub<TuttoStub> {
    private TuttoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TuttoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TuttoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TuttoStub(channel, callOptions);
    }

    /**
     */
    public void unlibro(proto.IdLibro request,
        io.grpc.stub.StreamObserver<proto.DettagliLibro> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UNLIBRO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void damminumero(proto.Ciao request,
        io.grpc.stub.StreamObserver<proto.NumeroLibri> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DAMMINUMERO, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TuttoBlockingStub extends io.grpc.stub.AbstractStub<TuttoBlockingStub> {
    private TuttoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TuttoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TuttoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TuttoBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.DettagliLibro unlibro(proto.IdLibro request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UNLIBRO, getCallOptions(), request);
    }

    /**
     */
    public proto.NumeroLibri damminumero(proto.Ciao request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DAMMINUMERO, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TuttoFutureStub extends io.grpc.stub.AbstractStub<TuttoFutureStub> {
    private TuttoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TuttoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TuttoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TuttoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.DettagliLibro> unlibro(
        proto.IdLibro request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UNLIBRO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.NumeroLibri> damminumero(
        proto.Ciao request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DAMMINUMERO, getCallOptions()), request);
    }
  }

  private static final int METHODID_UNLIBRO = 0;
  private static final int METHODID_DAMMINUMERO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TuttoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TuttoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UNLIBRO:
          serviceImpl.unlibro((proto.IdLibro) request,
              (io.grpc.stub.StreamObserver<proto.DettagliLibro>) responseObserver);
          break;
        case METHODID_DAMMINUMERO:
          serviceImpl.damminumero((proto.Ciao) request,
              (io.grpc.stub.StreamObserver<proto.NumeroLibri>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class TuttoDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.HelloService.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TuttoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TuttoDescriptorSupplier())
              .addMethod(METHOD_UNLIBRO)
              .addMethod(METHOD_DAMMINUMERO)
              .build();
        }
      }
    }
    return result;
  }
}
