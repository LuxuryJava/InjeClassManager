package ac.injecs.java2.frame;

import ac.injecs.java2.config.InjeFont;

import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {
    public RoundedButton() { super(); decorate(); }
    protected void decorate() { setBorderPainted(false); setOpaque(false); }
    @Override
    protected void paintComponent(Graphics g) {
        Color c = new Color(0x00AED6); //배경색 결정
        Color o = new Color(0xFFFFFF); //글자색 결정

        int width = getWidth();
        int height = getHeight();

        Graphics2D graphics = (Graphics2D) g;

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isArmed()) { graphics.setColor(c.darker()); }
        else if (getModel().isRollover()) { graphics.setColor(c.brighter()); }
        else { graphics.setColor(c); }

        graphics.fillRoundRect(0, 0, width, height, 50, 50);

        FontMetrics fontMetrics = graphics.getFontMetrics();

        Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

        int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

        graphics.setColor(o);
        graphics.setFont(InjeFont.Mfont);
        graphics.drawString(getText(), 30, textY);
        graphics.dispose();

        super.paintComponent(g);
    }
}
