# accreditationService
A spring boot service to validate if the given user is accredited.

Server port : 8080
Url serviced : localhost:8080/user/accreditation
# Sample request :
*{
  "user_id": "g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpE1V",
  "payload": {
    "accreditation_type": "BY_INCOME",
    "documents": [{
        "name": "2018.pdf",
        "mime_type": "application/pdf",
        "content": "ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg=="
      },{
        "name": "2019.jpg",
        "mime_type": "image/jpeg",
        "content": "91cy1wcm9taXNlICJeMi4wLjUiCiAgICB0b3Bvc29ydCAiXjIuMC4yIgo="
      }
    ]
  }
}*


