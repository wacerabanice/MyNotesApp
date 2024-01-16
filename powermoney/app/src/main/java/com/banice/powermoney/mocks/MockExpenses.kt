package com.banice.powermoney.mocks

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import androidx.compose.ui.graphics.Color
import com.banice.powermoney.models.Category
import com.banice.powermoney.models.Expense
import com.banice.powermoney.models.Recurrence
import io.github.serpro69.kfaker.Faker

val faker = Faker()

val mockCategories = listOf(
    Category(
        "Bills",
        Color(
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255)
        )
    ),
    Category(
        "Subscriptions", Color(
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255)
        )
    ),
    Category(
        "Take out", Color(
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255)
        )
    ),
    Category(
        "Hobbies", Color(
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255),
            faker.random.nextInt(0, 255)
        )
    ),
)

val mockExpenses: List<Expense> = List(30) {
    Expense(
        amount = faker.random.nextInt(min = 1, max = 999)
            .toDouble() + faker.random.nextDouble(),
        date = LocalDateTime.now().minus(
            faker.random.nextInt(min = 300, max = 345600).toLong(),
            ChronoUnit.SECONDS
        ),
        recurrence = faker.random.randomValue(
            listOf(
                Recurrence.None,
                Recurrence.Daily,
                Recurrence.Monthly,
                Recurrence.Weekly,
                Recurrence.Yearly
            )
        ),
        note = faker.australia.animals(),
        category = faker.random.randomValue(mockCategories)
    )
}