package com.github.justasbieliauskas.rmvm.command;

import com.github.justasbieliauskas.rmvm.data.*;

/**
 * Wrapper for AND, OR, XOR commands.
 *
 * @author Justas Bieliauskas
 */
public class Logical implements Command
{
    private final Commands commands;

    /**
     * @param a A register
     * @param expression word expression
     * @param status status register
     */
    public Logical(Register a, RWord expression, Register status) {
        this.commands = new Commands(
            new WordAssignment(a, expression),
            new ZeroCheck(status, expression),
            new FlagAssignment(new StatusFlag(status, 'C'), () -> false),
            new FlagAssignment(new StatusFlag(status, 'O'), () -> false)
        );
    }

    @Override
    public void execute() {
        this.commands.execute();
    }
}
