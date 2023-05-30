package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class VormerkkarteTest
{
    private Medium _medium;
    private Vormerkkarte _karte;
    private Kunde _kunde1;
    private Kunde _kunde2;
    private Kunde _kunde3;

    public VormerkkarteTest()
    {
        _medium = new CD("bar", "baz", "foo", 123);
        _karte = new Vormerkkarte(_medium);
        _kunde1 = new Kunde(new Kundennummer(123456), "ich", "du");
        _kunde2 = new Kunde(new Kundennummer(234567), "du", "ich");
        _kunde3 = new Kunde(new Kundennummer(345678), "wir", "ihr");
    }

    @Test
    public void testgetErstenVormerker()
    {
        _karte.enqueue(_kunde1);
        assertEquals(_kunde1, _karte.getErstenVormerker());
    }

    @Test
    public void testgetZweitenVormerker()
    {
        _karte.enqueue(_kunde1);
        _karte.enqueue(_kunde2);
        assertEquals(_kunde2, _karte.getZweitenVormerker());
    }

    @Test
    public void testgetDrittenVormerker()
    {
        _karte.enqueue(_kunde1);
        _karte.enqueue(_kunde2);
        _karte.enqueue(_kunde3);
        assertEquals(_kunde3, _karte.getDrittenVormerker());
    }

    @Test
    public void testgetSize()
    {
        _karte.enqueue(_kunde1);
        _karte.enqueue(_kunde2);
        assertEquals(2, _karte.getSize());
        _karte.enqueue(_kunde3);
        assertEquals(3, _karte.getSize());
        _karte.dequeue();
        _karte.dequeue();
        assertEquals(1, _karte.getSize());
    }

    @Test
    public void testpruefeObKundeEnthalten()
    {
        _karte.enqueue(_kunde1);
        _karte.enqueue(_kunde2);
        assertFalse(_karte.pruefeObKundeEnthalten(_kunde3));
        assertTrue(_karte.pruefeObKundeEnthalten(_kunde1));
        _karte.enqueue(_kunde3);
        assertTrue(_karte.pruefeObKundeEnthalten(_kunde3));

    }

}
