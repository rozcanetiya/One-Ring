ruleset("Means Test") {
    require(['income', 'expenses'])

    rule("nett income") {
        when {
            nett_income = income - expenses
            nett_income < 400.00
        }
        then {
            incomeTest = 'passed'
        }
        otherwise {
            incomeTest = 'failed'
        }
    }

    rule("nett income2") {
        evaluate {
            incomeTest2 = nett_income < 400.00
        }
    }

    rule("nett income3") {
        if (fact.nett_income > 400) {
            fact.incomeTest3 = 'rich bugger'
        } else {
            fact.incomeTest3 = 'poor bugger'
        }
    }
}