package ichttt.mods.mcpaint.common.capability;

import com.google.common.primitives.Shorts;

public class Paint implements IPaintable {
    private static final IPaintValidator TRUE_VALIDATOR = (pixelCountX, pixelCountY) -> true;

    private int[][] pictureData = null;
    private byte scaleFactor;
    private short pixelCountX;
    private short pixelCountY;
    private final IPaintValidator validator;

    public Paint() {
        this(TRUE_VALIDATOR);
    }

    public Paint(IPaintValidator validator) {
        this.validator = validator;
    }

    @Override
    public boolean hasPaintData() {
        return pictureData != null;
    }

    @Override
    public void setData(byte scaleFactor, int[][] pictureData) {
        short pixelCountX = Shorts.checkedCast(pictureData.length * scaleFactor);
        short pixelCountY = Shorts.checkedCast(pictureData[0].length * scaleFactor);
        if (!this.isValidPixelCount(pixelCountX, pixelCountY))
            throw new IllegalArgumentException("Invalid pixel count: x:" + pixelCountX + " y:" + pixelCountY);
        this.pixelCountX = pixelCountX;
        this.pixelCountY = pixelCountY;
        this.scaleFactor = scaleFactor;
        this.pictureData = pictureData;
    }

    @Override
    public byte getScaleFactor() {
        return this.scaleFactor;
    }

    @Override
    public int[][] getPictureData() {
        return this.pictureData;
    }

    @Override
    public short getPixelCountX() {
        return this.pixelCountX;
    }

    @Override
    public short getPixelCountY() {
        return this.pixelCountY;
    }

    @Override
    public final boolean isValidPixelCount(short pixelCountX, short pixelCountY) {
        return validator.isValidPixelCount(pixelCountX, pixelCountY);
    }
}
