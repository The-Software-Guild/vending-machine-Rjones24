package Service;

import DAO.AuditDao;
import DAO.VendingDao;
import DAO.VendingDaoFileImpl;
import DAO.VendingDaoStubImpl;
import DTO.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.List;

class VendingServiceLayerImplTest {

    private VendingServiceLayer service;

    public VendingServiceLayerImplTest() {
        VendingDao dao = new VendingDaoStubImpl();
        AuditDao auditDao = new VendingAuditDaoStubImpl();
        service = new VendingServiceLayerImpl(dao, auditDao);
    }

}