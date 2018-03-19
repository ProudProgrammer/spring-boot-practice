package hu.gaborbalazs.practice.springboot.component;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {

private final Logger LOGGER = LoggerFactory.getLogger(PrototypeBean.class);
    
    private int num;
    
    @PostConstruct
    public void init() {
        LOGGER.trace(">> init()");
    }

    public int getNum() {
        return num;
    }

    public void increaseNum() {
        num++;
    }
}
