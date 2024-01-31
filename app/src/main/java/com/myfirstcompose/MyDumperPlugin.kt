package com.myfirstcompose

import com.facebook.stetho.dumpapp.DumperContext
import com.facebook.stetho.dumpapp.DumperPlugin
import com.facebook.stetho.dumpapp.DumpException
import java.io.PrintWriter

open class MyDumperPlugin : DumperPlugin {

    // Override the getName method to provide a name for your plugin
    override fun getName(): String {
        return "my-dumper-plugin"
    }

    override fun dump(
        context: DumperContext
    ) {
        // Handle the dumping logic here
        try {
            // Example: Print a message to the dump output
            println("Hello from MyDumperPlugin!")

            // Add more custom dumping logic as needed

        } catch (e: DumpException) {
            // Handle dump exceptions if needed
            println("Error during dump: ${e.message}")
        }
    }
}
