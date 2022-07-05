package DAO;

public interface AuditDao {
    void writeAuditEntry(String entry) throws VendingPersistenceException;
}
