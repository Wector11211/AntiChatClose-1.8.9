package net.labymod.addons.Wector11211.AntiChatClose.ASM;

import net.labymod.core.asm.global.ClassEditor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class ProcessPacketEditor extends ClassEditor {
    public ProcessPacketEditor() {
        super(ClassEditorType.CLASS_NODE);
    }

    @Override
    public void accept(String name, ClassNode node) {
        for(MethodNode method : node.methods){
//            if("a".equals(method.name) || "func_148833_a".equals(method.name) || "processPacket".equals(method.name)){
            if("(Lep;)V".equals(method.desc) || "(Lnet/minecraft/network/INetHandler;)V".equals(method.desc)){
                System.out.println("[AntiChatClose] Found processPacket, hooking.");
                InsnList list = new InsnList();
                LabelNode label = new LabelNode();
                for (AbstractInsnNode instruction : method.instructions.toArray()) {
                    list.add(instruction);
                    if (instruction.getOpcode() == Opcodes.INVOKEINTERFACE || instruction instanceof LabelNode) {
                        list.add(new MethodInsnNode(Opcodes.INVOKESTATIC,
                                "net/labymod/addons/Wector11211/AntiChatClose/ASM/AntiChatCloseASM", "preventChatClosing", "()Z", false));
                        list.add(new JumpInsnNode(Opcodes.IFNE, label));
                    }
                }
                list.add(label);
                list.add(new InsnNode(Opcodes.RETURN));
                method.instructions.clear();
                method.instructions.insert(list);
            }
        }
    }

}
