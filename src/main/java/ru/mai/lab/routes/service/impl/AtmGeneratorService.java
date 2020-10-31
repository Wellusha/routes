package ru.mai.lab.routes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mai.lab.routes.config.AtmConfig;
import ru.mai.lab.routes.entity.Atm;
import ru.mai.lab.routes.util.RandomUtil;

@Service
public class AtmGeneratorService extends BaseGeneratorService<Atm> {

    private final AtmConfig config;

    @Autowired
    public AtmGeneratorService(AtmConfig config) {
        this.config = config;
    }

    @Override
    public Atm generate() {
        Atm atm = new Atm();

        atm.setIn(RandomUtil.nextInt(config.getMinIn(), config.getMaxIn()));
        atm.setOut(RandomUtil.nextInt(config.getMinOut(), config.getMaxOut()));
        atm.setExpected(RandomUtil.nextDouble(config.getMinExpected(), config.getMaxExpected()));
        atm.setDispersion(RandomUtil.nextDouble(config.getMinDispersion(), config.getMaxDispersion()));

        return atm;
    }

}
