package com.github.justasbieliauskas.rmvm.data;

/**
 * Nth register in collection of registers (processor).
 *
 * @author Justas Bieliauskas
 */
public class ProcessorRegister implements Register
{
    private final Register[] registers;

    private final RWord index;

    /**
     * @param registers all registers
     * @param id general purpose register identifier as byte value
     */
    public ProcessorRegister(Register[] registers, byte id) {
        this(registers, "" + (char)id);
    }

    /**
     * @param registers all register
     * @param id other register identifier
     */
    public ProcessorRegister(Register[] registers, String id) {
        this(registers, new RegisterIndex(id));
    }

    /**
     * @param registers all registers
     * @param index register index
     */
    public ProcessorRegister(Register[] registers, RWord index) {
        this.registers = registers;
        this.index = index;
    }

    @Override
    public int toInt() {
        return this.registers[this.index.toInt()].toInt();
    }

    @Override
    public void assign(int value) {
        this.registers[this.index.toInt()].assign(value);
    }
}
