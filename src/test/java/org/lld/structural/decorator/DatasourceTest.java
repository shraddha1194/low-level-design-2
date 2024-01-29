package org.lld.structural.decorator;

import org.junit.Test;
import org.lld.designPatterns.structural.decorator.datasource.CompressionDecorator;
import org.lld.designPatterns.structural.decorator.datasource.Datasource;
import org.lld.designPatterns.structural.decorator.datasource.EncryptionDecorator;
import org.lld.designPatterns.structural.decorator.datasource.FileDatasource;

import static org.junit.Assert.assertEquals;

public class DatasourceTest {

    @Test
    public void testRead() {
        Datasource db = new FileDatasource();
        assertEquals("If read is called, base should be returned", "Base", db.read());
    }

    @Test
    public void testEncryption() {
        Datasource db = new FileDatasource();
        Datasource encryptedDb = new EncryptionDecorator(db);

        assertEquals("If read is called, decrypted should be returned", "Base - Decrypted", encryptedDb.read());
    }

    @Test
    public void testEncryptionCompression() {
        Datasource db = new FileDatasource();
        Datasource encryptedDb = new EncryptionDecorator(db);
        Datasource compressedDb = new CompressionDecorator(encryptedDb);

        assertEquals("If read is called, decrypted should be returned", "Base - Decrypted - Decompressed", compressedDb.read());
    }

}
