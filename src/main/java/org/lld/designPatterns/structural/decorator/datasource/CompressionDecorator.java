package org.lld.designPatterns.structural.decorator.datasource;


public class CompressionDecorator extends BaseDecorator {

    public CompressionDecorator(Datasource nextLayer) {
        super(nextLayer);
    }

    @Override
    public String read() {
        String compressed = nextLayer.read();
        return decompress(compressed);
    }

    @Override
    public void write(String value) {
        String compressed = compress(value);
        nextLayer.write(compressed);
    }

    private String compress(String value) {
        return value + " - Compressed";
    }

    private String decompress(String value) {
        return value + " - Decompressed";
    }
}
