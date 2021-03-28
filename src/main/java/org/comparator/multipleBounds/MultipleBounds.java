package org.comparator.multipleBounds;

import org.example.App;

import java.io.*;
import java.nio.CharBuffer;

public class MultipleBounds {
    /* Readable interface has a read method to read into a buffer from a source, the Appendable interface has
    an append method to copy from a buffer into a target, and the Closeable interface has a close method to
    close a source or target. Possible sources and targets include files, buffers, streams, and so on. */

    /* For maximum flexibility, we might want to write a copy method that takes any source that implements both
       Readable and Closeable and any target that implements both Appendable and Closeable: */

    //This method repeatedly reads from the source into a buffer and appends from the buffer into a target.
    // When the source is empty, it closes both the source and the target
    public static <S extends Readable & Closeable, T extends Appendable & Closeable> void copy(S src, T trg, int size)
            throws IOException {
        try{
            CharBuffer buf = CharBuffer.allocate(size);
            int i = src.read(buf);
            while(i >= 0){
                buf.flip(); //prepare buffer for writing
                trg.append(buf);
                buf.clear(); //prepare buffer for reading
                i = src.read(buf);
            }
        }finally{
            src.close();
            trg.close();
        }
    }
// copy() method may be called with two files as source and target, or with the same two files wrapped in buffers
// as source and target
    public static void main(String[] args) throws IOException {
        int size = 32;
        FileReader r = new FileReader("file.in");
        FileWriter w = new FileWriter("file.out");
        copy(r, w, size);

        BufferedReader br = new BufferedReader(new FileReader("file.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("file.out"));
        copy(br, bw, size);
    }
    /* When multiple bounds appear, the first bound is used for erasure*/
}
