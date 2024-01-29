package org.lld.designPatterns.structural.decorator.datasource;

import lombok.AllArgsConstructor;

public class EncryptionDecorator extends BaseDecorator {

    public EncryptionDecorator(Datasource nextLayer) {
        super(nextLayer);
    }

    @Override
    public String read() {
        String value = nextLayer.read();
        return decrypt(value);
    }

    @Override
    public void write(String value) {
        // encrypt the value
        String encrypted = encrypt(value);
        nextLayer.write(encrypted);
    }

    private String encrypt(String value) {
        return value + " - Encrypted";
    }

    private String decrypt(String value) {
        return value + " - Decrypted";
    }
}
