package fr.umlv.careAtHome.persistence;

import fr.umlv.careAtHome.persistence.beans.Patient;
import fr.umlv.careAtHome.persistence.dao.impl.PatientDAO;
import fr.umlv.m2.jee.dao.IDAO;
import fr.umlv.m2.jee.dao.TestAbstractDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/persistance-test-context.xml"})
public class testPatientDAO extends TestAbstractDAO<Long, Patient> {
    @Qualifier("patientDAO")
    @Autowired
    private PatientDAO patientDAO;

    @Override
    protected long countAll() {
        return 3;
    }

    @Override
    protected IDAO<Long, Patient> getIDAO() {
        return patientDAO;
    }

    @Test
    public void testFindByName() {
        assertEquals(patientDAO.findPatientByUuid(1), patientDAO.searchPatientByFirstName("Jack"));
    }
}
