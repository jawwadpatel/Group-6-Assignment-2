/*
 * Decompiled with CFR 0_115.
 */
package library.interfaces.daos;

import java.util.List;
import library.interfaces.entities.IMember;

public interface IMemberDAO {
    public IMember addMember(String var1, String var2, String var3, String var4);

    public IMember getMemberByID(int var1);

    public List<IMember> listMembers();

    public List<IMember> findMembersByLastName(String var1);

    public List<IMember> findMembersByEmailAddress(String var1);

    public List<IMember> findMembersByNames(String var1, String var2);
}

