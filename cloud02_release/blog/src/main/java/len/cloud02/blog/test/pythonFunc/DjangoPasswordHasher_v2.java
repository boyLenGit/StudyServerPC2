package len.cloud02.blog.test.pythonFunc;


import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;


class DjangoPasswordHasher_v2 {
    public final Integer DEFAULT_ITERATIONS = 10000;
    public final String algorithm = "pbkdf2_sha256";

    public DjangoPasswordHasher_v2() {
    }

    public String getEncodedHash(String password, String salt, int iterations) {
        SecretKeyFactory keyFactory = null;
        try {
            keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Could NOT retrieve PBKDF2WithHmacSHA256 algorithm");
            System.exit(1);
        }
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(Charset.forName("UTF-8")), iterations, 256);
        SecretKey secret = null;
        try {
            secret = keyFactory.generateSecret(keySpec);
        } catch (InvalidKeySpecException e) {
            System.out.println("Could NOT generate secret key");
            e.printStackTrace();
        }

        byte[] rawHash = secret.getEncoded();
        byte[] hashBase64 = Base64.getEncoder().encode(rawHash);

        return new String(hashBase64);
    }

    public String encode(String password, String salt, int iterations) {
        // returns hashed password, along with algorithm, number of iterations and salt
        String hash = getEncodedHash(password, salt, iterations);
        return String.format("%s$%d$%s$%s", algorithm, iterations, salt, hash);
    }

    public String encode(String password, String salt) {
        return this.encode(password, salt, this.DEFAULT_ITERATIONS);
    }

    public static void main(String[] args) {
        checkPassword_v3();
    }

    public static void checkPassword_v2() {
        // hashedPassword consist of: ALGORITHM, ITERATIONS_NUMBER, SALT and
        // HASH; parts are joined with dollar character ("$")
        String hashedPassword = "pbkdf2_sha256$10000$wD0uwdBCDzhw$MRHskq8rLtB7H0DanstNn0ZDW65qOwApjg/8K5W4VWM=";
        String password = "123";
        String salt_input = "1q3OWZJe2lwP";
        DjangoPasswordHasher_v2 djangoPasswordHasher = new DjangoPasswordHasher_v2();
        String[] parts = hashedPassword.split("\\$");
        if (parts.length != 4) {
            // wrong hash format
            return;
        }
        int iterations = Integer.parseInt(parts[1]);
        String salt = parts[2];
        String hash = djangoPasswordHasher.encode(password, salt_input, iterations);

        System.out.println(hash);
    }

    public static void checkPassword_v3() {
        // hashedPassword consist of: ALGORITHM, ITERATIONS_NUMBER, SALT and
        // HASH; parts are joined with dollar character ("$")
        String password = "123";
        String salt_input = "1q3OWZJe2lwP";
        DjangoPasswordHasher_v2 djangoPasswordHasher = new DjangoPasswordHasher_v2();

        String hash = djangoPasswordHasher.encode(password, salt_input, 10000);

        System.out.println(hash);
    }


}
