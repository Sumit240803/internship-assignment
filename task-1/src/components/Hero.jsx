import React from 'react'
import "../assets/css/Hero.css"
const Hero = () => {
    return (
        <div className='main'>
            <div className='heading'>

                <div id='home' className='content'>
                    <h1>EcoVita AI</h1>
                   <p> EMPOWER FUTURE THROUGH AI IN <span>HEALTH</span> <span>CLIMATE </span>& <span>HABITS</span></p>
                </div>
                <div className='buttons'>

                <button>Join The Revolution</button>
                <button>Know More About AI</button>
                </div>
            </div>
            <div id='about' className="aboutus">About Us</div>
            <div  className='about'>
                <div className='card card-health'>
                    <div className='card-content'>
                        <h3>Health Innovation</h3>
                        <p>Transforming healthcare with AI-driven solutions for personalized medicine, predictive analytics, and better patient care.</p>
                    </div>
                </div>
                <div className='card card-climate'>
                    <div className='card-content'>
                        <h3>Climate Action</h3>
                        <p>Utilizing AI to optimize energy consumption, reduce emissions, and drive sustainability efforts in combating climate change.</p>
                    </div>
                </div>
                <div className='card card-habits'>
                    <div className='card-content'>
                        <h3>Habit Transformation</h3>
                        <p>Empowering individuals to improve their daily habits, boost productivity, and enhance well-being using AI insights.</p>
                    </div>
                </div>

            </div>
            <div id='products' className="aboutus">Products</div>
            <div className='about products'>
                <div className='product'>
                    <div className="product-details health">
                    </div>
                    <div className='info'>
                        <h3 className='productHeading'>AI-Powered Diagnostics</h3>
                        <p className='productInfo'>  AI tools for early disease detection, such as predicting the onset of eye diseases or identifying cancers through imaging.</p>
                    </div>
                </div>
                <div className='product'>
                    <div className="product-details carbon">
                    </div>
                    <div className='info'>
                        <h3 className='productHeading'>Carbon Tracking</h3>
                        <p className='productInfo'>  Use of AI to monitor deforestation and assess the impact of carbon-offset projects.</p>
                    </div>
                </div>
                <div className='product'>
                    <div className="product-details habit">
                    </div>
                    <div className='info'>
                        <h3 className='productHeading'>Behavioral Tracking</h3>
                        <p className='productInfo'>  AI to provide habit-building programs for better mental and physical health.</p>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Hero