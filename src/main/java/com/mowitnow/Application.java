package com.mowitnow;

import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;
import com.mowitnow.service.LawnService;
import com.mowitnow.service.MowerService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

@SpringBootApplication
public class Application {

    private LawnService lawnService;
    private MowerService mowerService;

    private static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                lawnService = ctx.getBean(LawnService.class);
                mowerService = ctx.getBean(MowerService.class);
                InputStream inputStream = new FileInputStream(args[0]);
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                    Lawn lawn = lawnService.initLawn(reader.readLine());
                    String line;
                    while ((line = reader.readLine()) != null) {
                        Mower mower = mowerService.initMower(line, lawn);
                        mowerService.executeInstructions(mower, reader.readLine());
                        logger.log(Level.INFO, "Mower's final position : " + mower.getPosition());
                    }
                }
            }
        };
    }
}
