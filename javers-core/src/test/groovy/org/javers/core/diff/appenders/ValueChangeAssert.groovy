package org.javers.core.diff.appenders

import org.javers.core.diff.changetype.ValueChange
import org.javers.model.mapping.Property

class ValueChangeAssert {

    def ValueChange actual;

    private ValueChangeAssert(ValueChange actual) {
        this.actual = actual;
    }

    static ValueChangeAssert assertThat(ValueChange actual) {
        return new ValueChangeAssert(actual)
    }

    def hasGlobalId(Class expected, Object expectedCdoId, String expectedFragment ){
        assert actual.globalCdoId.entity.sourceClass == expected
        assert actual.globalCdoId.cdoId == expectedCdoId
        assert actual.globalCdoId.fragment == expectedFragment
        this
    }

    def hasProperty(Property expected) {
        assert actual.property == expected
        return this
    }

    def hasLeftValue(Object expected) {
        assert actual.leftValue.value == expected
        return this;
    }

    def hasRightValue(Object expected) {
        assert actual.rightValue.value == expected
        return this;
    }

    def haveLeftValueNull() {
        hasLeftValue(null)
    }
}