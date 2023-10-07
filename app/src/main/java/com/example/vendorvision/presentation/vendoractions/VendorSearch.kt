import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

data class Vendor(
    val name: String,
    val service: ServiceType,
    val details: String
)

enum class ServiceType {
    SOFTWARE_SOLUTIONS,
    OFFICE_SUPPLIER,
    EVENTS
}

@Composable
fun VendorsPage(navController: DestinationsNavigator) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf("All") }
    var isDropdownExpanded by remember { mutableStateOf(false) }
    val filters = listOf("All", "SOFTWARE_SOLUTIONS", "OFFICE_SUPPLIER", "EVENTS")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        // Dropdown for filtering
        Box {
            TextButton(onClick = { isDropdownExpanded = true }) {
                Text(selectedFilter, color = Color(0xFF4CAF50)) // Dark Green
            }
            DropdownMenu(
                expanded = isDropdownExpanded,
                onDismissRequest = { isDropdownExpanded = false }
            ) {
                filters.forEach { filter ->
                    DropdownMenuItem(onClick = {
                        selectedFilter = filter
                        isDropdownExpanded = false
                    }) {
                        Text(filter)
                    }
                }
            }
        }

        // Search bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Vendors") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // List of vendors
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(vendors) { vendor ->
                if ((selectedFilter == "All" || vendor.service.toString() == selectedFilter) &&
                    (searchQuery.isEmpty() || vendor.name.contains(searchQuery, ignoreCase = true))) {
                    VendorTile(vendor = vendor, onClick = {
                        navController.navigate(route = "VendorSpending")
                    })
                }
            }
        }
    }
}

@Composable
fun VendorTile(vendor: Vendor, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color(0xFFC8E6C8), shape = RoundedCornerShape(12.dp)) // Light green with rounded corners
            .padding(16.dp)
            .clickable(onClick = onClick)
    ) {
        Text(text = "${vendor.name} - ${vendor.details}", color = Color.Black) // Text color changed to black
    }
}

val vendors = listOf(
    Vendor(
        name = "TechSolutions Inc.",
        service = ServiceType.SOFTWARE_SOLUTIONS,
        details = "Software."
    ),
    Vendor(
        name = "OfficeEssentials Ltd.",
        service = ServiceType.OFFICE_SUPPLIER,
        details = "Office supplies."
    ),
    Vendor(
        name = "EventMasters Co.",
        service = ServiceType.EVENTS,
        details = "Event management."
    ),
    Vendor(
        name = "SoftWave Tech",
        service = ServiceType.SOFTWARE_SOLUTIONS,
        details = "Software products."
    ),
    Vendor(
        name = "SupplyChain Hub",
        service = ServiceType.OFFICE_SUPPLIER,
        details = "Office supplies."
    ),
    Vendor(
        name = "Gala Organizers",
        service = ServiceType.EVENTS,
        details = "Event planning."
    )
)

