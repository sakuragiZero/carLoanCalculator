package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        calculateButton.setOnClickListener {
            val CarPrice = priceNum.text.toString()
            val DownPayment = paymentNum.text.toString()
            val CarPriceAmount:Double = CarPrice.toDouble()
            val DownPaymentAmount:Double = DownPayment.toDouble()
            val CarLoan = CarPriceAmount - DownPaymentAmount
            // loan  * interest * period
            val InterestRate = interestRate.text.toString()
            val PaymentPeriod = loanTime.text.toString()
            val InterestRateAmount:Double = InterestRate.toDouble()/100
            val PaymentPeriodTime:Int = PaymentPeriod.toInt()
            val InterestTotal = CarLoan * InterestRateAmount * PaymentPeriodTime

            //(loan+interest)/loan period /12 months
            val FinalCount:Double = (CarLoan + InterestRateAmount) / PaymentPeriodTime / 12

            loanID.text = "RM" + CarLoan
            interestID.text = "RM%.2f".format(InterestTotal)
            monthID.text = "Rm%.2f".format(FinalCount)
        }
    }
}

