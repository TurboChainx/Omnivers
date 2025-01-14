package com.example.checkscanner.helpers;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;

import hawaiiappbuilders.omniversapp.depositcheck.helpers.Quadrilateral;

public class ScannedDocument {

    public Mat original;
    public Mat processed;
    public Quadrilateral quadrilateral;
    public Point[] previewPoints;
    public Size previewSize;

    public ScannedDocument(Mat original) {
        this.original = original;
    }

    public Mat getProcessed() {
        return processed;
    }

    public ScannedDocument setProcessed(Mat processed) {
        this.processed = processed;
        return this;
    }

    public void release() {
        if (processed != null) {
            processed.release();
        }
        if (original != null) {
            original.release();
        }

        if (quadrilateral != null && quadrilateral.contour != null) {
            quadrilateral.contour.release();
        }
    }
}
