package org.example.dubbo.consumer.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @author qiqiang
 */
@Activate(group = CommonConstants.CONSUMER)
public class ExampleFilter implements Filter, Filter.Listener {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("before ExampleFilter");
        return invoker.invoke(invocation);
    }

    @Override
    public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
        System.out.println(appResponse);
    }

    @Override
    public void onError(Throwable t, Invoker<?> invoker, Invocation invocation) {
        System.out.println(t);
    }
}