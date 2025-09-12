# ParkUp Home Screen Design Documentation

## Overview
The `activity_home.xml` layout provides a comprehensive and modern home screen for the ParkUp IoT parking management application. This screen serves as the main dashboard where users can view real-time parking information and access key features.

## Design Features

### 1. **App Bar & Header**
- **Material Design Toolbar** with primary blue background
- **Welcome message** and app title display
- **Refresh button** for updating parking status in real-time
- **Elevated design** with shadow for modern appearance

### 2. **Parking Overview Cards**
- **Total Slots Card** (Blue): Shows total number of parking spaces
- **Available Slots Card** (Green): Displays currently available spaces
- **Occupied Slots Card** (Red): Shows occupied parking spaces
- **Responsive layout** with equal weight distribution
- **Rounded corners** and elevation for modern card design

### 3. **Live Slot Status Section**
- **Visual grid representation** of all parking slots (6x4 grid for 24 slots)
- **Color-coded status indicators**:
  - 🟢 **Green**: Available slots
  - 🔴 **Red**: Occupied slots  
  - 🟠 **Orange**: Reserved slots
- **Status legend** for easy understanding
- **View All Slots button** for detailed slot information

### 4. **Quick Actions Section**
- **Find Parking** (Green): Search for available parking spots
- **My Bookings** (Orange): View user's parking reservations
- **Payment History** (Dark Blue): Access transaction records
- **Settings** (Gray): Configure app preferences
- **Icon integration** with descriptive text for better UX

## Layout Structure

```
CoordinatorLayout
├── AppBarLayout
│   └── Toolbar (with welcome message, title, refresh button)
└── NestedScrollView
    └── LinearLayout (Main Content)
        ├── Last Updated Info
        ├── Parking Overview Section
        │   └── Overview Cards (3 horizontal cards)
        ├── Live Status Section
        │   ├── Status Legend
        │   ├── Slot Grid (6x4)
        │   └── View All Slots Button
        └── Quick Actions Section
            ├── Row 1: Find Parking + My Bookings
            └── Row 2: Payment History + Settings
```

## Color Scheme

### Primary Colors
- **Primary Blue**: `#FF2196F3` - Main app theme
- **Primary Dark**: `#FF1976D2` - Secondary elements
- **Light Gray**: `#FFF5F5F5` - Background

### Status Colors
- **Available**: `#FF4CAF50` - Green for free slots
- **Occupied**: `#FFF44336` - Red for taken slots
- **Reserved**: `#FFFF9800` - Orange for reserved slots

### UI Elements
- **Card Background**: `#FFFFFFFF` - White for content cards
- **Medium Gray**: `#FFE0E0E0` - Borders and dividers
- **Dark Gray**: `#FF757575` - Secondary text

## Key Components

### Material Design Components Used
- `CoordinatorLayout` - For coordinated scrolling behavior
- `AppBarLayout` - For collapsible app bar
- `MaterialCardView` - For elevated content cards
- `MaterialButton` - For action buttons with icons
- `NestedScrollView` - For smooth scrolling content
- `GridLayout` - For parking slot grid display

### Interactive Elements
- **Refresh Button**: Updates parking status from IoT sensors
- **Slot Grid**: Visual representation of parking availability
- **Action Buttons**: Navigate to different app sections
- **View All Slots**: Expands to detailed slot view

## Implementation Notes

### 1. **Dynamic Content**
- Parking slot counts are updated dynamically from IoT sensor data
- Slot grid status is populated programmatically based on real-time data
- Last updated timestamp shows when data was last refreshed

### 2. **Responsive Design**
- Cards use weight-based layout for different screen sizes
- Grid layout adapts to available space
- Proper margins and padding for consistent spacing

### 3. **Accessibility**
- Content descriptions for interactive elements
- High contrast color scheme for visibility
- Proper text sizing for readability

### 4. **Performance**
- Efficient layout hierarchy for smooth scrolling
- Optimized drawable resources
- Minimal nested layouts for better rendering

## Future Enhancements

### 1. **Real-time Updates**
- WebSocket integration for live IoT sensor data
- Push notifications for slot status changes
- Auto-refresh functionality

### 2. **Interactive Features**
- Tap on slots for detailed information
- Swipe gestures for navigation
- Haptic feedback for interactions

### 3. **Personalization**
- User preferences for display options
- Customizable quick actions
- Theme selection (light/dark mode)

### 4. **Analytics Integration**
- Parking usage statistics
- Peak hours visualization
- Revenue tracking display

## Dependencies Required

Ensure these dependencies are added to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.2.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}
```

## Usage

This layout is designed to be used with `HomeActivity` and provides:
- Real-time parking status monitoring
- Quick access to key app features
- Intuitive navigation for users
- Professional and modern appearance

The design follows Material Design guidelines and provides an excellent user experience for IoT-based parking management applications.
