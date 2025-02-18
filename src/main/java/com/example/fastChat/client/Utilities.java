package com.example.fastChat.client;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;

import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Utilities {
    public static final Color TRANSPARENT = new Color(0, 0, 0, 0);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color TEXT_COLOR = new Color(255, 255, 255);
    public static final Color RED = new Color(255, 0, 0);
    public static final Color SECONDARY_COLOR = new Color(0, 255, 0);
    public static final Color BLUE = new Color(0, 0, 255);
    public static final Color PRIMARY_COLOR = new Color(255, 0, 0);

    public static EmptyBorder addPadding(int top, int left, int bottom, int right) {
        return new EmptyBorder(top, left, bottom, right);
    }
}
