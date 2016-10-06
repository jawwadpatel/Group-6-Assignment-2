/*
 * Decompiled with CFR 0_115.
 */
package library.interfaces.hardware;

import library.interfaces.hardware.ICardReaderListener;

public interface ICardReader {
    public void addListener(ICardReaderListener var1);

    public void setEnabled(boolean var1);
}

