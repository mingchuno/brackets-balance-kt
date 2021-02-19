package me.mcor

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Example kotest test case
 */
class BalanceBracketsTest : StringSpec({
    "simple case to check" {
        balanceBrackets("(a)") shouldBe "(a)"
        balanceBrackets("((a)") shouldBe "(a)"
        balanceBrackets("(())") shouldBe "(())"
        balanceBrackets("()()") shouldBe "()()"
        balanceBrackets("(a())") shouldBe "(a())"
        balanceBrackets("(a(b))") shouldBe "(a(b))"
        balanceBrackets("(a(b)c)") shouldBe "(a(b)c)"
        balanceBrackets("((())") shouldBe "(())"
        balanceBrackets("(()))") shouldBe "(())"
        balanceBrackets("((a)()") shouldBe "(a)()"
        balanceBrackets("((a)(())") shouldBe "(a)(())"
        balanceBrackets(")))(((") shouldBe ""
        balanceBrackets("()(a)") shouldBe "()(a)"
        balanceBrackets("()(a))") shouldBe "()(a)"
        balanceBrackets("aabb()(a))") shouldBe "aabb()(a)"
        balanceBrackets("aabb()(a))ccc") shouldBe "aabb()(a)ccc"
        balanceBrackets("((((((((((((()") shouldBe "()"
        balanceBrackets("(a(((a(((a(((((()") shouldBe "aaa()"
        balanceBrackets("))a))(a((a(") shouldBe "aaa"
    }
})
