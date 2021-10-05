package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AssessmentTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Assessment(null));
    }

    @Test
    public void constructor_invalidAssessment_throwsIllegalArgumentException() {
        String invalidAssessment = "";
        assertThrows(IllegalArgumentException.class, () -> new Assessment(invalidAssessment));
    }

    @Test
    public void isValidAssessment() {
        // null assessment
        assertThrows(NullPointerException.class, () -> Assessment.isValidAssessment(null));

        // invalid assessments
        assertFalse(Assessment.isValidAssessment("")); // empty string
        assertFalse(Assessment.isValidAssessment(" ")); // spaces only
        assertFalse(Assessment.isValidAssessment("assessment")); // words only
        assertFalse(Assessment.isValidAssessment("01")); // missing type
        assertFalse(Assessment.isValidAssessment("PP01")); // invalid type
        assertFalse(Assessment.isValidAssessment("P")); // missing numbering
        assertFalse(Assessment.isValidAssessment("P1")); // invalid numbering
        assertFalse(Assessment.isValidAssessment("P110")); // exceeding length

        // valid assessments
        assertTrue(Assessment.isValidAssessment("P01")); // uppercase type
        assertTrue(Assessment.isValidAssessment("p01")); // lowercase type
    }

    @Test
    public void reformatAssessment() {
        assertEquals("P01", Assessment.reformatAssessment("p01"));
    }
}