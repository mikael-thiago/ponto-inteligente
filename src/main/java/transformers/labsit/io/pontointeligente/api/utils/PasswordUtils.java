package transformers.labsit.io.pontointeligente.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
    private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);

    public static String gerarBCrypt(String senha) {
        if (senha == null)
            return senha;

        log.info("Gerando hash com BCrypt");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return passwordEncoder.encode(senha);
    }

}
