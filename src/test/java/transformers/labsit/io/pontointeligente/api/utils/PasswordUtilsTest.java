package transformers.labsit.io.pontointeligente.api.utils;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtilsTest {
  private static final String SENHA = "123456";
  private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

  @Test
  void testSenhaNula() throws Exception {
    assertNull(PasswordUtils.gerarBCrypt(null));
  }

  @Test
  void testGerarHashSenha() throws Exception {
    String hash = PasswordUtils.gerarBCrypt(SENHA);

    assertTrue(bCryptPasswordEncoder.matches(SENHA, hash));
  }
}
