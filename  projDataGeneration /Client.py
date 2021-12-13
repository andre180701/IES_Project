import itertools

class Client:
    newid = itertools.count().next
    def __init__(self, registration, deviceId) -> None:
        self._id = Client.newid()
        self._registration = registration
        self._deviceId = deviceId

    @property
    def id(self):
        return self._id

    @property
    def registration(self):
        return self._registration

    @property
    def deviceId(self):
        return self._deviceId

    @registration.setter
    def registration(self, registration):
        self._registration = registration

    @deviceId.setter
    def deviceId(self, deviceId):
        self._deviceId = deviceId

    '''
    def __str__(self) -> str:
        return 

    def __repr__(self) -> str:
        return self.__str__()
    '''
