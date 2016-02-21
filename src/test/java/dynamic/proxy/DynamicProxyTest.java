package dynamic.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by hanmomhanda on 2016-02-20.
 */
public class DynamicProxyTest {

    @Test
    public void dynamicProxy() throws Exception {
        Target dynamicProxy =
                (Target)Proxy.newProxyInstance(
                        getClass().getClassLoader(),
                        new Class[] {Target.class},
                        new AsteriskProxy(new Target() {
                            @Override
                            public String sayHello(String name) {
                                return "Hello " + name;
                            }
                        })
                );
        assertThat(dynamicProxy.sayHello("Homo Efficio"), is("***Hello Homo Efficio***"));
    }
}

// target 객체의 interface
interface Target {
    String sayHello(String name);
}

// Dynamic Proxy가 되려면 java.lang.InvocationHandler를 구현해야함
class AsteriskProxy implements InvocationHandler {

    private Target target;

    public AsteriskProxy(Target target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 실제 target 객체의 메서드를 실행
        // target 객체의 모든 메서드가 이 invoke()에 의해 호출
        String realResult = (String)method.invoke(target, args);

        // 부가 기능 추가
        // target 객체의 모든 메서드가 이 invoke()에 의해 호출되므로
        // 부가 기능은 여기에만 추가하면 target 객체의 모든 메서드에 적용
        String decoratedResult = "***" + realResult + "***";

        return decoratedResult;
    }
}