package org.darion.protocol;

import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;
import com.google.protobuf.Service;

public class EchoService implements Service {

  @Override
  public ServiceDescriptor getDescriptorForType() {
    return null;
  }

  @Override
  public void callMethod(MethodDescriptor method, RpcController controller, Message request,
      RpcCallback<Message> done) {

  }

  @Override
  public Message getRequestPrototype(MethodDescriptor method) {
    return null;
  }

  @Override
  public Message getResponsePrototype(MethodDescriptor method) {
    return null;
  }

}
