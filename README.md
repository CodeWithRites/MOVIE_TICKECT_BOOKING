🎬 Cinema Ticket Booking System

A full-stack Java web application for managing cinema ticket bookings, featuring real-time seat selection, calendar-based scheduling, and Razorpay payment gateway integration.
This system provides both user-facing booking functionality and admin management capabilities, making it a complete end-to-end movie ticketing platform.

🧩 Overview

The Cinema Ticket Booking System simplifies the process of movie ticket reservation by digitizing every step — from movie selection to ticket generation.
It replicates real-world functionality found in major online ticketing systems (like BookMyShow), but designed from scratch using JSP, Servlets, and MySQL.

This project showcases:

Backend logic with Servlets + JDBC

Dynamic JSP rendering for the user interface

Secure online payments using Razorpay API

Database-driven session and booking management

💡 Motivation

Traditional movie booking processes involve manual reservations or fragmented online systems.
This project was developed to:

Demonstrate real-world software engineering principles using Java EE.

Build a scalable, maintainable system with modular architecture.

Provide hands-on experience integrating third-party APIs (Razorpay).

Strengthen database interaction skills through complex relational queries.

The goal was not only to build a functional system but to follow professional standards of design, readability, and scalability.

⚙️ Key Features
🎟 User Module

Register and login securely using a MySQL-backed authentication system.

Browse movies and select showtimes dynamically loaded from the database.

View available seats in an interactive layout.

Select desired date from an integrated calendar system.

Calculate total cost dynamically as seats are selected.

Make online payments via Razorpay test integration.

Download a digital ticket as a PDF file post-payment.

🧑‍💼 Admin Module

Add, update, or delete movies and showtimes.

Manage pricing and theaters.

View all bookings and payment records.

Monitor seat availability in real-time.

💰 Payment Integration

Fully functional Razorpay API integration for real payments in test mode.

Secure transaction handling using generated order_id and payment verification.

📅 Calendar Booking

Users select their preferred date directly in the booking_admin.jsp.

The chosen date is propagated through payment.jsp, ticket.jsp, and stored in the database (booking_date column).

🚀 How It Works

User Login/Register → Session created.

Movie Selection → Dynamic movie list fetched from DB.

Seat Booking → Interactive grid rendered using JSP loop.

Date Selection → HTML5 Calendar integrated.

Payment Process → Razorpay API creates order.

Confirmation → Data stored in DB (booking table).

Ticket Generation → PDF generated dynamically.


💾 Data Flow Diagram

USER WORK FLOW

<img width="1366" height="768" alt="USER WORK FLOW" src="https://github.com/user-attachments/assets/07d21bdb-5bb5-4539-bb41-731ca93fb730" />

ADMIN WORK FLOW

<img width="1366" height="768" alt="ADMIN WORK FLOW" src="https://github.com/user-attachments/assets/5e770d67-2dc3-4119-8ee0-bd3178360bfc" />


🧠 Learning Outcomes

This project helped in mastering:

Java Servlet lifecycle (doGet, doPost)

Session handling and request forwarding

JSP scripting, expressions, and JSTL

SQL integration and prepared statements

Razorpay payment integration with API keys

Error handling, redirects, and exception management

Real-time state management for seat availability

📈 Future Enhancements

Implement JWT-based authentication for better security.

Introduce role-based admin dashboard.

Add QR Code validation on tickets.

Integrate email confirmations via SMTP API.

Use Spring Boot + REST APIs for scalability.

Add React/Angular frontend for a modern UI.


