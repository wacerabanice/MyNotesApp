package net.pata.ui.theme.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import net.pata.R
import net.pata.ui.theme.auth.AuthViewModel
import net.pata.ui.theme.spacing


@Composable
fun AboutScreen(viewModel: AuthViewModel?, navController: NavHostController) {

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (refHeader, refTextPata, refTextLoans, refTextReq, refButtonLogin, refButtonRegister) = createRefs()
        val spacing = MaterialTheme.spacing


        Box(
            modifier = Modifier
                .constrainAs(refHeader) {
                    top.linkTo(parent.top, spacing.extraLarge)
                    start.linkTo(parent.start, spacing.extraLarge)
                    end.linkTo(parent.end, spacing.extraLarge)
                    width = Dimension.fillToConstraints
                }
                .wrapContentSize()
        ) {
            Image(
                modifier = Modifier
                    .size(138.dp, 138.dp),
                painter = painterResource(id = R.drawable.coinit),
                contentDescription = stringResource(id = R.string.app_name)
            )
        }
        Text(
            modifier = Modifier
                .constrainAs(refTextPata) {
                    top.linkTo(refHeader.bottom, spacing.large)
                    start.linkTo(parent.start, spacing.extraLarge)
                    end.linkTo(parent.end, spacing.extraLarge)
                },
            text = "About Pata:" +
                    " A simple app to assist SMEs calculate their elligibility to financing and Bank Loans \n" +
                    "            based on their Monthly average turnovers, Monthly average bankings and their \n" +
                    "            Asset to Debt Ratio."

        )

        Box(
            modifier = Modifier
                .constrainAs(refTextLoans) {
                    top.linkTo(parent.top, spacing.extraLarge)
                    start.linkTo(parent.start, spacing.extraLarge)
                    end.linkTo(parent.end, spacing.extraLarge)
                    width = Dimension.fillToConstraints
                }
                .wrapContentSize()

        ) {
            Image(
                modifier = Modifier
                    .size(138.dp, 138.dp),
                painter = painterResource(id = R.drawable.coinit),
                contentDescription = stringResource(id = R.string.app_name)
            )
        }
        Text(
            modifier = Modifier
                .constrainAs(refTextReq) {
                    top.linkTo(refTextPata.bottom, spacing.large)
                    start.linkTo(parent.start, spacing.extraLarge)
                    end.linkTo(parent.end, spacing.extraLarge)
                },
            text = "Factors that Banks consider when giving loans:" +
                    " Credit History \n" +
                    " Cash Flows \n" +
                    " Collateral or Security \n" +
                    "Repayment Capacity \n" +
                    "Documentation"
        )
    }
}











