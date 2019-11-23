package com.example.yoga01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class NutritionActivity : AppCompatActivity() {
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition)

        listView = findViewById<ListView>(R.id.recipe_list_view)

        val recipeList = Recipe.getRecipesFromFile("recipe.json", this)

        val adapter = RecipeAdapter(this, recipeList)
        listView.adapter = adapter

        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedRecipe = recipeList[position]

            val detailIntent = RecipeDetailsActivity.newIntent(context, selectedRecipe)

            startActivity(detailIntent)


        }
    }
}
