package ch.aurachain.thirft;

import ch.aurachain.thirft.generated.CrossPlatformResource;
import ch.aurachain.thirft.generated.CrossPlatformService;
import ch.aurachain.thirft.generated.InvalidOperationException;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CrossPlatformServiceImpl implements CrossPlatformService.Iface{
    @Override
    public CrossPlatformResource get(int id)
            throws InvalidOperationException, TException {
        return new CrossPlatformResource(1,"Bogdan");
    }

    @Override
    public void save(CrossPlatformResource resource)
            throws InvalidOperationException, TException {

    }

    @Override
    public List<CrossPlatformResource> getList()
            throws InvalidOperationException, TException {
        return Collections.emptyList();
    }

    @Override
    public boolean ping() throws InvalidOperationException, TException {
        return true;
    }
}
