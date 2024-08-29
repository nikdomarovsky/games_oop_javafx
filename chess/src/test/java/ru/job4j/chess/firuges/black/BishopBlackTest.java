package ru.job4j.chess.firuges.black;

import org.junit.Test;
import static org.junit.Assert.*;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.ImpossibleMoveException;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertEquals(Cell.C1, bishop.position());
    }

    @Test
    public void testCopy() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Figure copiedBishop = bishop.copy(Cell.G5);
        assertEquals(Cell.G5, copiedBishop.position());
    }

    @Test
    public void testWay() throws ImpossibleMoveException {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] expectedPath = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(expectedPath, bishop.way(Cell.G5));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWayException() throws ImpossibleMoveException {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        bishop.way(Cell.G6);
    }

    @Test
    public void testIsDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertTrue(bishop.isDiagonal(Cell.C1, Cell.G5));
        assertFalse(bishop.isDiagonal(Cell.C1, Cell.G6));
    }
}
